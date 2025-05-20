package jtt.putans.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jtt.putans.connection.Database;
import jtt.putans.dao.AttributeDAO;

import jtt.putans.dto.Attribute;
import jtt.putans.queries.AttributeQueries;

public class AttributeDAOImpl implements AttributeDAO, AttributeQueries {

	@Override
	public int insert(Attribute value) throws SQLException {
			Connection conn = Database.getConnection();
			List<Attribute> attribute = getAllData();
			
			boolean attributeE = false;
			
			for (Attribute a : attribute) {
				if(a.getName().equals(value.getName())) {
					attributeE = true;
					break;
				}
			}
			
			if(attributeE) return 0;
			
			PreparedStatement stmt = conn.prepareStatement(QUERY_INSERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			
			stmt.setString(1, value.getName());
			
			int result = stmt.executeUpdate();
			
			return result;
	}

	@Override
	public int update(Attribute value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int delete(Attribute value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int getID(Attribute value) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1,  value.getName());
	

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		int id = rs.getInt("id_attribute");
		
		return id;
	}

	@Override
	public Attribute getByID(int id) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		String name = rs.getString("AttributeName");

		Attribute attribute = new Attribute(name);
		attribute.setAttribute_id(id);
		
		return attribute;
	}

	@Override
	public List<Attribute> getAllData() throws SQLException {
		Connection conn = Database.getConnection();
		List<Attribute> attribute = new ArrayList<>();
		
		Statement stmt = conn.prepareStatement(QUERY_GET_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(QUERY_GET_ALL);
		
		while(rs.next()) {
			int id = rs.getInt("id_attribute");
			String name = rs.getString("AttributeName");
			
			Attribute attribute1 = new Attribute(name);
			attribute1.setAttribute_id(id);
			attribute.add(attribute1);
		}
		return attribute;
	}

	@Override
	public Attribute getByName(String name) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_NAME, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1, name);

		ResultSet rs = stmt.executeQuery();
		if(!rs.isBeforeFirst()){
		    return null;
		}
		else {
		rs.first();
		
		int id = rs.getInt("id_attribute");
		String name1 = rs.getString("customerName");

		Attribute attribute = new Attribute(name1);
		attribute.setAttribute_id(id);
		
		return attribute;
	}
	}

}
