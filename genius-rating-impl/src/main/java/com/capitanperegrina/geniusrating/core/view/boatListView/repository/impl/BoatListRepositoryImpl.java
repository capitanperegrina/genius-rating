package com.capitanperegrina.geniusrating.core.view.boatListView.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capitanperegrina.geniusrating.core.entity.boat.repository.BoatRepositoryNaming;
import com.capitanperegrina.geniusrating.core.view.boatListView.BoatListView;
import com.capitanperegrina.geniusrating.core.view.boatListView.repository.BoatListRepository;
import com.capitanperegrina.utils.sql.QueryUtils;
import com.capitanperegrina.utils.sql.ResultSetUtils;

@Repository
public class BoatListRepositoryImpl implements BoatListRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoatListRepositoryImpl.class);

	private static RowMapper<BoatListView> mapper = new RowMapper<BoatListView>() {
		@Override
		public BoatListView mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoatListView obj = new BoatListView();
			obj.setBoatId(ResultSetUtils.getInteger(BoatRepositoryNaming.BOAT_ID, rs));
			obj.setBoatName(ResultSetUtils.getString(BoatRepositoryNaming.BOAT_NAME, rs));
			obj.setBuiltYear(ResultSetUtils.getInteger(BoatRepositoryNaming.BUILT_YEAR, rs));
			obj.setShipyard(ResultSetUtils.getString(BoatRepositoryNaming.SHIPYARD, rs));
			obj.setModel(ResultSetUtils.getString(BoatRepositoryNaming.MODEL, rs));
			obj.setLoa(ResultSetUtils.getBigDecimal(BoatRepositoryNaming.LOA, rs));
			obj.setsNumber(ResultSetUtils.getBigDecimal(BoatRepositoryNaming.NUM_S, rs));
			obj.setRating(ResultSetUtils.getBigDecimal(BoatRepositoryNaming.RATING, rs));
			return obj;
		}
	};

	@Autowired(required=false)
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoatListView> find(Integer edition, Integer ownerId) {
		// TODO - Read this from a queries sql properties file. It'll need a QuerReaderFromResource class.
		String q = "SELECT b.boat_id, b.boat_name, b.built_year, b.shipyard, b.model, bd_loa.value AS loa, bd_s.value AS num_s, bd_rating.value AS rating "
				+ "FROM boat b "
				+ "LEFT JOIN boat_data bd_loa ON bd_loa.boat_id = b.boat_id AND bd_loa.edition = :edition AND bd_loa.key = 'loa' "
				+ "LEFT JOIN boat_data bd_s ON bd_s.boat_id = b.boat_id AND bd_s.edition = :edition AND bd_s.key = 'numS' "
				+ "LEFT JOIN boat_data bd_rating ON bd_rating.boat_id = b.boat_id AND bd_rating.edition = :edition AND bd_rating.key = 'ftc' ";
		q = q.replace(":edition", edition.toString());
		List<Object> p = new ArrayList<>();
		if ( ownerId != null ) {
			q = q + "WHERE b.owner_id = ? ";
			p.add(ownerId);
		}
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(QueryUtils.queryLog(q, p));
		}
		return this.jdbcTemplate.query(q.toString(), p.toArray(), mapper);
	}
}