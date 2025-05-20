package jtt.putans.queries;

public interface SetQueries {
 final String TABLE = "set";
	
	
	final String QUERY_INSERT = "INSERT INTO " + TABLE + "(set_name, set_code, release_date) VALUES (?,?, STR_TO_DATE(?, '%Y-%m-%d'))";
	
	final String QUERY_UPDATE = "UPDATE " + TABLE + " SET set_name = ? , set_code = ? release_date = STR_TO_DATE(?, '%Y-%m-%d')  WHERE set_id = ?";

	final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE set_name = ? , set_code = ? release_date = STR_TO_DATE(?, '%Y-%m-%d')";

	final String QUERY_GET_ID = "SELECT set_id FROM " + TABLE + " WHERE set_name = ? , set_code = ? release_date = STR_TO_DATE(?, '%Y-%m-%d')";
	final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE set_id = ?";
	final String QUERY_GET_BY_NAME = "SELECT * FROM " + TABLE + " WHERE set_name = ?";
	final String QUERY_GET_BY_CODE = "SELECT * FROM " + TABLE + " WHERE set_code = ?";
	final String QUERY_GET_BY_DATE = "SELECT * FROM " + TABLE + " WHERE release_date = ?";
	final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
