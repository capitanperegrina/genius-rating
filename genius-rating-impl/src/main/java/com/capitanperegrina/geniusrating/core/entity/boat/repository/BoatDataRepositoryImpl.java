package com.capitanperegrina.geniusrating.core.entity.boat.repository;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capitanperegrina.geniusrating.core.entity.boat.BoatData;
import com.capitanperegrina.utils.sql.GenericRepository;
import com.capitanperegrina.utils.sql.QueryUtils;
import com.capitanperegrina.utils.sql.ResultSetUtils;

/**
 * Objeto de acceso a datos para la tabla <code>boat_data<code>
 */
@Repository
@Transactional(propagation=Propagation.SUPPORTS)
public class BoatDataRepositoryImpl extends GenericRepository implements BoatDataRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoatDataRepositoryImpl.class);

    public static final String WHERE_BY_KEY = " boat_data_id = ?  ";

    public static final String ENTITY = BoatData.class.getName();
    public static final String TABLE = "boat_data";
    public static final String FIELDS_ALL = "boat_data_id, edition, boat_id, key, value, type, created_by, created_date, modified_by, modified_date ";
    public static final String FIELDS_INSERT = " ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ";
    public static final String FIELDS_UPDATE = " edition = ?, boat_id = ?, key = ?, value = ?, type = ?, created_by = ?, created_date = ?, modified_by = ?, modified_date = ? ";
    public static final String FIELDS_PRIMARY_KEY = " boat_data_id = ? ";

	private static RowMapper<BoatData> mapper = new RowMapper<BoatData>() {
	    @Override
	    public BoatData mapRow( ResultSet rs, int rowNum ) throws SQLException {
	        BoatData obj = new BoatData();
	        obj.setBoatDataId( ResultSetUtils.getInteger(BoatRepositoryNaming.BOAT_DATA_ID, rs) );
	        obj.setEdition( ResultSetUtils.getInteger(BoatRepositoryNaming.EDITION, rs) );
	        obj.setBoatId( ResultSetUtils.getInteger(BoatRepositoryNaming.BOAT_ID, rs) );
	        obj.setKey( ResultSetUtils.getString(BoatRepositoryNaming.KEY, rs) );
	        obj.setValue( ResultSetUtils.getString(BoatRepositoryNaming.VALUE, rs) );
	        obj.setType( ResultSetUtils.getString(BoatRepositoryNaming.TYPE, rs) );
	        obj.setCreatedBy( ResultSetUtils.getInteger(BoatRepositoryNaming.CREATED_BY, rs) );
	        obj.setCreatedDate( ResultSetUtils.getTimestamp(BoatRepositoryNaming.CREATED_DATE, rs) );
	        obj.setModifiedBy( ResultSetUtils.getInteger(BoatRepositoryNaming.MODIFIED_BY, rs) );
	        obj.setModifiedDate( ResultSetUtils.getTimestamp(BoatRepositoryNaming.MODIFIED_DATE, rs) );
	    	return obj;
	    }
	};

    @Autowired(required=false)
    private JdbcTemplate jdbcTemplate;

    private static Object[] toParamsAll( BoatData obj ) {
        return ArrayUtils.addAll( toParamsKey( obj ) , toParamsRest( obj ) );
    }

    private static Object[] toParamsUpdate( BoatData obj ) {
        return ArrayUtils.addAll( toParamsRest( obj ), toParamsKey( obj ) );
    }

    private static Object[] toParamsKey( BoatData obj ) {
        return new Object[] {
            obj.getBoatDataId()
         };
    }

    private static Object[] toParamsRest( BoatData obj ) {
        return new Object[] {
            obj.getEdition(),
            obj.getBoatId(),
            obj.getKey(),
            obj.getValue(),
            obj.getType(),
            obj.getCreatedBy(),
            obj.getCreatedDate(),
            obj.getModifiedBy(),
            obj.getModifiedDate()
        };
    }

    @Override
	public BoatData create( BoatData obj ) {
		try {
			StringBuilder q = new StringBuilder("");
			Object[] p = new Object[] {};
			q.append("LOCK TABLES " + TABLE + " WRITE;");
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace(QueryUtils.queryLog(q, p));
			}
			this.jdbcTemplate.update(q.toString(), p);

			q = new StringBuilder("");
			p = new Object[] {};
			q.append("SELECT IFNULL( MAX( user_id ) + 1, 1 ) FROM " + TABLE + ";");
			Integer newId = this.jdbcTemplate.queryForObject(q.toString(), p, Integer.class);

			q = new StringBuilder("");
			p = new Object[] { newId, obj.getEdition(), obj.getBoatId(), obj.getKey(), obj.getValue(), obj.getType(),
					obj.getCreatedBy(), obj.getCreatedDate(), obj.getModifiedBy(), obj.getModifiedDate() };
			q.append("INSERT INTO " + TABLE + " ( " + FIELDS_ALL + " ) \n");
			q.append("VALUES ( " + FIELDS_INSERT + " ) \n");

			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace(QueryUtils.queryLog(q, p));
			}
			this.jdbcTemplate.update(q.toString(), p);
			obj.setBoatId(newId);
			return obj;
		} catch (DuplicateKeyException e) {
			LOGGER.debug("Duplicated key", e);
			throw e;
		} finally {
			StringBuilder q = new StringBuilder("");
			Object[] p = new Object[] {};
			q.append("UNLOCK TABLES;\n");

			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace(QueryUtils.queryLog(q, p));
			}
			this.jdbcTemplate.update(q.toString(), p);
		}
    }

    @Override
	public boolean exists( BoatData obj ) {
        StringBuilder q = new StringBuilder();
        Object[] p = toParamsKey(obj);
        q.append(generateExistsQuery());
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return (this.jdbcTemplate.queryForObject(q.toString(), p, Integer.class)) > 0;
    }

    @Override
	public BoatData find( BoatData obj ) {
        StringBuilder q = new StringBuilder();
        Object[] p = toParamsKey(obj);
        q.append(generateSelectQuery());
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return this.jdbcTemplate.queryForObject(q.toString(), p, mapper);
    }

    @Override
	public void update( BoatData obj ) {
		StringBuilder q = new StringBuilder();
		Object[] p = toParamsUpdate(obj);
		q.append(generateUpdateQuery());
		if (LOGGER.isTraceEnabled()) {
		    LOGGER.trace(QueryUtils.queryLog(q, p));
		}
		this.jdbcTemplate.update(q.toString(), p);
    }

    @Override
	public void delete( BoatData obj ) {
		StringBuilder q = new StringBuilder();
		Object[] p = toParamsKey(obj);
		q.append(generateDeleteQuery());
		if (LOGGER.isTraceEnabled()) {
		    LOGGER.trace(QueryUtils.queryLog(q, p));
		}
		this.jdbcTemplate.update(q.toString(), p);
    }

    @Override
	public List<BoatData> findAll() {
        StringBuilder q = new StringBuilder();
        Object[] p = {};
        q.append(generateSelectQuery("1=1"));
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return this.jdbcTemplate.query(q.toString(), mapper);
    }

    @Override
	public List<BoatData> findSome( BoatData obj ) {
        if ( obj == null ) {
            return findAll();
        }

        StringBuilder cond = new StringBuilder(" 1=1 ");
        List<Object> parametros = new ArrayList<>();

        if ( obj.getBoatDataId() != null ) {
            cond.append( "   AND boat_data_id = ? " );
            parametros.add( obj.getBoatDataId() );
        }
        if ( obj.getEdition() != null ) {
            cond.append( "   AND edition = ? " );
            parametros.add( obj.getEdition() );
        }
        if ( obj.getBoatId() != null ) {
            cond.append( "   AND boat_id = ? " );
            parametros.add( obj.getBoatId() );
        }
        if ( obj.getKey() != null ) {
            cond.append( "   AND key = ? " );
            parametros.add( obj.getKey() );
        }
        if ( obj.getValue() != null ) {
            cond.append( "   AND value = ? " );
            parametros.add( obj.getValue() );
        }
        if ( obj.getType() != null ) {
            cond.append( "   AND type = ? " );
            parametros.add( obj.getType() );
        }
        if ( obj.getCreatedBy() != null ) {
            cond.append( "   AND created_by = ? " );
            parametros.add( obj.getCreatedBy() );
        }
        if ( obj.getCreatedDate() != null ) {
            cond.append( "   AND created_date = ? " );
            parametros.add( obj.getCreatedDate() );
        }
        if ( obj.getModifiedBy() != null ) {
            cond.append( "   AND modified_by = ? " );
            parametros.add( obj.getModifiedBy() );
        }
        if ( obj.getModifiedDate() != null ) {
            cond.append( "   AND modified_date = ? " );
            parametros.add( obj.getModifiedDate() );
        }

        Object[] p = parametros.toArray();
        StringBuilder q = new StringBuilder();
        q.append(generateSelectQuery( cond.toString() ));
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return this.jdbcTemplate.query(q.toString(), p, mapper);
    }

    @Override
    protected String getTable() {
        return TABLE;
    }

    @Override
    protected String getFields() {
        return FIELDS_ALL;
    }

    @Override
    protected String getInsertQuestionMarks() {
        return FIELDS_INSERT;
    }

    @Override
    protected String getWhereByKey() {
        return FIELDS_PRIMARY_KEY;
    }

    @Override
    protected String getFieldsUpdate() {
       return FIELDS_UPDATE;
    }
}