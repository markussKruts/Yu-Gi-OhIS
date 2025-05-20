package jtt.putans.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jtt.putans.connection.Database;
import jtt.putans.dao.RaritiesDAO;
import jtt.putans.dto.Rarities;
import jtt.putans.queries.RaritiesQueries;

public class RaritiesDAOImpl implements RaritiesDAO, RaritiesQueries {

	@Override
	public int insert(Rarities value) throws SQLException {
		Connection conn = Database.getConnection();
		List<Rarities> rarity = getAllData();
		
		boolean rarityE = false;
		
		for (Rarities a : rarity) {
			if(a.getName().equals(value.getName())) {
				rarityE = true;
				break;
			}
		}
		
		if(rarityE) return 0;
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_INSERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		
		stmt.setString(1, value.getName());
		
		int result = stmt.executeUpdate();
		
		return result;
	}

	@Override
	public int update(Rarities value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int delete(Rarities value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int getID(Rarities value) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1,  value.getName());
	

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		int id = rs.getInt("id_rarity");
		
		return id;
	}

	@Override
	public Rarities getByID(int id) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		String name = rs.getString("RaceName");

		Rarities rarity = new Rarities(name);
		rarity.setRarity_id(id);
		
		return rarity;
	}

	@Override
	public List<Rarities> getAllData() throws SQLException {
		Connection conn = Database.getConnection();
		List<Rarities> rarity = new ArrayList<>();
		
		Statement stmt = conn.prepareStatement(QUERY_GET_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(QUERY_GET_ALL);
		
		while(rs.next()) {
			int id = rs.getInt("id_rarity");
			String name = rs.getString("rarity_Name");
			
			Rarities raritiy1 = new Rarities(name);
			raritiy1.setRarity_id(id);
			rarity.add(raritiy1);
		}
		return rarity;
	}

	@Override
	public Rarities getByName(String name) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_NAME, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1, name);

		ResultSet rs = stmt.executeQuery();
		if(!rs.isBeforeFirst()){
		    return null;
		}
		else {
		rs.first();
		
		int id = rs.getInt("id_rarity");
		String name1 = rs.getString("rarityName");

		Rarities rarity = new Rarities(name1);
		rarity.setRarity_id(id);
		
		return rarity;
	}
	}

}
