package jtt.putans.queries;

public interface RaceQueries {
 final String TABLE = "race";
	
	
	final String QUERY_INSERT = "INSERT INTO " + TABLE + "(race_name) VALUES (?)";
	
	final String QUERY_UPDATE = "UPDATE " + TABLE + " SET race_name = ?  WHERE race_id = ?";

	final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE race_name = ?";

	final String QUERY_GET_ID = "SELECT race_id FROM " + TABLE + " WHERE race_name = ?";
	final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE race_id = ?";
	final String QUERY_GET_BY_NAME = "SELECT * FROM " + TABLE + " WHERE race_name = ?";
	final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
