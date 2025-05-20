package jtt.putans.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import jtt.putans.connection.Database;
import jtt.putans.dao.ArchetypeDAO;
import jtt.putans.dto.Archetype;
import jtt.putans.queries.ArchetypeQueries;

public class ArchetypeImpl implements ArchetypeDAO, ArchetypeQueries {

	@Override
	public int insert(Archetype value) throws SQLException {
		Connection conn = Database.getConnection();
		List<Archetype> type = getAllData();
		
		boolean archetypeE = false;
		
		for (Archetype a : type) {
			if(a.getName().equals(value.getName())) {
				archetypeE = true;
				break;
			}
		}
		
		if(archetypeE) return 0;
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_INSERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		
		stmt.setString(1, value.getName());
		
		int result = stmt.executeUpdate();
		
		return result;
	}

	@Override
	public int update(Archetype value) throws SQLException {
Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	
	}

	@Override
	public int delete(Archetype value) throws SQLException {
	Connection conn = Database.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.setString(1,  value.getName());
		
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public int getID(Archetype value) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1,  value.getName());
	

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		int id = rs.getInt("id_customer");
		
		return id;
	}
	

	@Override
	public Archetype getByID(int id) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		rs.first();
		
		String name = rs.getString("ArchetypeName");

		Archetype archetype = new Archetype(name);
		archetype.setArchetype_id(id);
		
		return archetype;
	}

	@Override
	public List<Archetype> getAllData() throws SQLException {
		Connection conn = Database.getConnection();
		List<Archetype> archetype = new ArrayList<>();
		
		Statement stmt = conn.prepareStatement(QUERY_GET_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(QUERY_GET_ALL);
		
		while(rs.next()) {
			int id = rs.getInt("id_archetype");
			String name = rs.getString("ArchetypeName");
			
			Archetype archetype1 = new Archetype(name);
			archetype1.setArchetype_id(id);
			archetype.add(archetype1);
		}
		return archetype;
	}

	@Override
	public Archetype getByName(String name) throws SQLException {
		Connection conn = Database.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_NAME, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.setString(1, name);

		ResultSet rs = stmt.executeQuery();
		if(!rs.isBeforeFirst()){
		    return null;
		}
		else {
		rs.first();
		
		int id = rs.getInt("id_archetype");
		String name1 = rs.getString("customerName");

		Archetype archetype = new Archetype(name);
		archetype.setArchetype_id(id);
		
		return archetype;
	}

	}
}
