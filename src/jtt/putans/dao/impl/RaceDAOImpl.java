package jtt.putans.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jtt.putans.connection.Database;
import jtt.putans.dao.RaceDAO;

import jtt.putans.dto.Race;
import jtt.putans.queries.RaceQueries;

public class RaceDAOImpl implements RaceDAO, RaceQueries {

	@Override
	public int insert(Race value) throws SQLException {
		Connection conn = Database.getConnection();
		List<Race> race = getAllData();
		
		boolean raceE = false;
		
		for (Race a : race) {
			if(a.getName().equals(value.getName())) {
				raceE = true;
				break;
			}
		}
		
		if(raceE) return 0;
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_INSERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		
		stmt.setString(1, value.getName());
		
		int result = stmt.executeUpdate();
		
		return result;
	}

	@Override
	public int update(Race value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int delete(Race value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int getID(Race value) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1,  value.getName());
	

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		int id = rs.getInt("id_race");
		
		return id;
	}

	@Override
	public Race getByID(int id) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		String name = rs.getString("RaceName");

		Race race = new Race(name);
		race.setRace_id(id);
		
		return race;
	}

	@Override
	public List<Race> getAllData() throws SQLException {
		Connection conn = Database.getConnection();
		List<Race> race = new ArrayList<>();
		
		Statement stmt = conn.prepareStatement(QUERY_GET_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(QUERY_GET_ALL);
		
		while(rs.next()) {
			int id = rs.getInt("id_race");
			String name = rs.getString("raceName");
			
			Race race1 = new Race(name);
			race1.setRace_id(id);
			race.add(race1);
		}
		return race;
	}

	@Override
	public Race getByName(String name) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_NAME, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1, name);

		ResultSet rs = stmt.executeQuery();
		if(!rs.isBeforeFirst()){
		    return null;
		}
		else {
		rs.first();
		
		int id = rs.getInt("id_race");
		String name1 = rs.getString("raceName");

		Race race = new Race(name1);
		race.setRace_id(id);
		
		return race;
	}
	}

}
