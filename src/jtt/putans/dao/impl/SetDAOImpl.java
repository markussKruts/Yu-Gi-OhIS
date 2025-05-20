package jtt.putans.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jtt.putans.connection.Database;
import jtt.putans.dao.SetDAO;
import jtt.putans.dto.Rarities;
import jtt.putans.dto.Set;
import jtt.putans.queries.SetQueries;

public class SetDAOImpl implements SetDAO, SetQueries {

	@Override
	public int insert(Set value) throws SQLException {
		Connection conn = Database.getConnection();
		List<Set> set = getAllData();
		
		boolean setE = false;
		
		for (Set a : set) {
			if(a.getName().equals(value.getName()) &&  a.getCode().equals(value.getCode()) && a.getRelease_date().equals(value.getRelease_date())) {
				setE = true;
				break;
			}
		}
		
		if(setE) return 0;
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_INSERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		
		stmt.setString(1, value.getName());
		stmt.setString(2, value.getCode());
		stmt.setDate(3, value.getRelease_date());
		
		int result = stmt.executeUpdate();
		
		return result;
	}

	@Override
	public int update(Set value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1, value.getName());
		stmt.setString(2, value.getCode());
		stmt.setDate(3, value.getRelease_date());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int delete(Set value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1, value.getName());
		stmt.setString(2, value.getCode());
		stmt.setDate(3, value.getRelease_date());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int getID(Set value) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1, value.getName());
		stmt.setString(2, value.getCode());
		stmt.setDate(3, value.getRelease_date());
	

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		int id = rs.getInt("id_set");
		
		return id;
	}

	@Override
	public Set getByID(int id) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		String name = rs.getString("SetName");
        String code = rs.getString("SetCode");
        Date date = rs.getDate("release_date");
        
		Set set = new Set(name, code, date);
		set.setId_set(id);
		
		return set;
	}

	@Override
	public List<Set> getAllData() throws SQLException {
		Connection conn = Database.getConnection();
		List<Set> set = new ArrayList<>();
		
		Statement stmt = conn.prepareStatement(QUERY_GET_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(QUERY_GET_ALL);
		
		while(rs.next()) {
			int id = rs.getInt("id_set");
			String name = rs.getString("set_Name");
			String code = rs.getString("SetCode");
	        Date date = rs.getDate("release_date");
	        
			Set set1 = new Set(name, code, date);
			set1.setId_set(id);
			set.add(set1);
		}
		return set;
	}

	@Override
	public Set getByName(String name) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_NAME, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1, name);

		ResultSet rs = stmt.executeQuery();
		if(!rs.isBeforeFirst()){
		    return null;
		}
		else {
		rs.first();
		
		int id = rs.getInt("id_set");
		String name1 = rs.getString("set_Name");

		Set set = new Set(name1);
		set.setId_set(id);
		
		return set;
	}
	}

	@Override
	public Set getByCode(String code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getByReleaseDate(Date date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
