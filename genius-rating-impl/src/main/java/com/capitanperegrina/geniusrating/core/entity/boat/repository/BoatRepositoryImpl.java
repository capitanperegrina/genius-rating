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

import com.capitanperegrina.geniusrating.core.entity.boat.Boat;
import com.capitanperegrina.utils.sql.GenericRepository;
import com.capitanperegrina.utils.sql.QueryUtils;
import com.capitanperegrina.utils.sql.ResultSetUtils;
/**
 * Objeto de acceso a datos para la tabla <code>boat<code>
 */
@Repository
@Transactional(propagation=Propagation.SUPPORTS)
public class BoatRepositoryImpl extends GenericRepository implements BoatRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoatRepositoryImpl.class);

    public static final String WHERE_BY_KEY = " boat_id = ?  ";

    public static final String ENTITY = Boat.class.getName();
    public static final String TABLE = "boat";
    public static final String FIELDS_ALL = "boat_id, owner_id, boat_name, design_year, built_year, shipyard, model, number_masts, created_by, created_date, modified_by, modified_date ";
    public static final String FIELDS_INSERT = " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ";
    public static final String FIELDS_UPDATE = " owner_id = ?, boat_name = ?, design_year = ?, built_year = ?, shipyard = ?, model = ?, number_masts = ?, created_by = ?, created_date = ?, modified_by = ?, modified_date = ? ";
    public static final String FIELDS_PRIMARY_KEY = " boat_id = ? ";

	private static RowMapper<Boat> mapper = new RowMapper<Boat>() {
	    @Override
	    public Boat mapRow( ResultSet rs, int rowNum ) throws SQLException {
	        Boat obj = new Boat();
	        obj.setBoatId( ResultSetUtils.getInteger(BoatRepositoryNaming.BOAT_ID, rs) );
	        obj.setOwnerId( ResultSetUtils.getInteger(BoatRepositoryNaming.OWNER_ID, rs) );
	        obj.setBoatName( ResultSetUtils.getString(BoatRepositoryNaming.BOAT_NAME, rs) );
	        obj.setDesignYear( ResultSetUtils.getInteger(BoatRepositoryNaming.DESIGN_YEAR, rs) );
	        obj.setBuiltYear( ResultSetUtils.getInteger(BoatRepositoryNaming.BUILT_YEAR, rs) );
	        obj.setShipyard( ResultSetUtils.getString(BoatRepositoryNaming.SHIPYARD, rs) );
	        obj.setModel( ResultSetUtils.getString(BoatRepositoryNaming.MODEL, rs) );
	        obj.setNumberMasts( ResultSetUtils.getInteger(BoatRepositoryNaming.NUMBER_MASTS, rs) );
	        obj.setCreatedBy( ResultSetUtils.getInteger(BoatRepositoryNaming.CREATED_BY, rs) );
	        obj.setCreatedDate( ResultSetUtils.getTimestamp(BoatRepositoryNaming.CREATED_DATE, rs) );
	        obj.setModifiedBy( ResultSetUtils.getInteger(BoatRepositoryNaming.MODIFIED_BY, rs) );
	        obj.setModifiedDate( ResultSetUtils.getTimestamp(BoatRepositoryNaming.MODIFIED_DATE, rs) );
	    	return obj;
	    }
	};    
    
    @Autowired(required=false)
    private JdbcTemplate jdbcTemplate;

    private static Object[] toParamsAll( Boat obj ) {
        return ArrayUtils.addAll( toParamsKey( obj ) , toParamsRest( obj ) );
    }

    private static Object[] toParamsUpdate( Boat obj ) {
        return ArrayUtils.addAll( toParamsRest( obj ), toParamsKey( obj ) );
    }

    private static Object[] toParamsKey( Boat obj ) {
        return new Object[] {
            obj.getBoatId()
         };
    }

    private static Object[] toParamsRest( Boat obj ) {
        return new Object[] {
            obj.getOwnerId(),
            obj.getBoatName(),
            obj.getDesignYear(),
            obj.getBuiltYear(),
            obj.getShipyard(),
            obj.getModel(),
            obj.getNumberMasts(),
            obj.getCreatedBy(),
            obj.getCreatedDate(),
            obj.getModifiedBy(),
            obj.getModifiedDate()
        };
    }

    @Override
	public Boat create(Boat obj) {
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
			p = new Object[] { newId, obj.getOwnerId(), obj.getBoatName(), obj.getDesignYear(), obj.getBuiltYear(),
					obj.getShipyard(), obj.getModel(), obj.getNumberMasts(), obj.getCreatedBy(), obj.getCreatedDate(),
					obj.getModifiedBy(), obj.getModifiedDate() };
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
	public boolean exists( Boat obj ) {
        StringBuilder q = new StringBuilder();
        Object[] p = toParamsKey(obj);
        q.append(generateExistsQuery());
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return (this.jdbcTemplate.queryForObject(q.toString(), p, Integer.class)) > 0;
    }

    @Override
	public Boat find( Boat obj ) {
        StringBuilder q = new StringBuilder();
        Object[] p = toParamsKey(obj);
        q.append(generateSelectQuery());
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return this.jdbcTemplate.queryForObject(q.toString(), p, mapper);
    }

    @Override
	public void update( Boat obj ) {
		StringBuilder q = new StringBuilder();
		Object[] p = toParamsUpdate(obj);
		q.append(generateUpdateQuery());
		if (LOGGER.isTraceEnabled()) {
		    LOGGER.trace(QueryUtils.queryLog(q, p));
		}
		this.jdbcTemplate.update(q.toString(), p);
    }

    @Override
	public void delete( Boat obj ) {
		StringBuilder q = new StringBuilder();
		Object[] p = toParamsKey(obj);
		q.append(generateDeleteQuery());
		if (LOGGER.isTraceEnabled()) {
		    LOGGER.trace(QueryUtils.queryLog(q, p));
		}
		this.jdbcTemplate.update(q.toString(), p);
    }

    @Override
	public List<Boat> findAll() {
        StringBuilder q = new StringBuilder();
        Object[] p = {};
        q.append(generateSelectQuery("1=1"));
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(QueryUtils.queryLog(q, p));
        }
        return this.jdbcTemplate.query(q.toString(), mapper);
    }

    @Override
	public List<Boat> findSome( Boat obj ) {
        if ( obj == null ) {
            return findAll();
        }

        StringBuilder cond = new StringBuilder(" 1=1 ");
        List<Object> parametros = new ArrayList<>();

        if ( obj.getBoatId() != null ) {
            cond.append( "   AND boat_id = ? " );
            parametros.add( obj.getBoatId() );
        }
        if ( obj.getOwnerId() != null ) {
            cond.append( "   AND owner_id = ? " );
            parametros.add( obj.getOwnerId() );
        }
        if ( obj.getBoatName() != null ) {
            cond.append( "   AND boat_name = ? " );
            parametros.add( obj.getBoatName() );
        }
        if ( obj.getDesignYear() != null ) {
            cond.append( "   AND design_year = ? " );
            parametros.add( obj.getDesignYear() );
        }
        if ( obj.getBuiltYear() != null ) {
            cond.append( "   AND built_year = ? " );
            parametros.add( obj.getBuiltYear() );
        }
        if ( obj.getShipyard() != null ) {
            cond.append( "   AND shipyard = ? " );
            parametros.add( obj.getShipyard() );
        }
        if ( obj.getModel() != null ) {
            cond.append( "   AND model = ? " );
            parametros.add( obj.getModel() );
        }
        if ( obj.getNumberMasts() != null ) {
            cond.append( "   AND number_masts = ? " );
            parametros.add( obj.getNumberMasts() );
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