package jtt.putans.queries;

public class AttributeQueries {
	private final String TABLE = "attribute";
	
	
	final String QUERY_INSERT_1 = "INSERT INTO " + TABLE + "(attribute_name) VALUES (?)";
	
	final String QUERY_UPDATE = "UPDATE " + TABLE + " SET attribute_name = ?  WHERE attribute_id = ?";

	final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE attribute_name = ?";

	final String QUERY_GET_ID = "SELECT attribute_id FROM " + TABLE + " WHERE attribute_name = ?";
	final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE attribute_id = ?";
	final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
