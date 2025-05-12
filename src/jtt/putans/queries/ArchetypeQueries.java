package jtt.putans.queries;

public class ArchetypeQueries {
	private final String TABLE = "archetype";
	
	
 final String QUERY_INSERT_1 = "INSERT INTO " + TABLE + "(archetype_name) VALUES (?)";
	
final String QUERY_UPDATE = "UPDATE " + TABLE + " SET archetype_name = ?  WHERE archetype_id = ?";

final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE archetype_name = ?";

final String QUERY_GET_ID = "SELECT archetype_id FROM " + TABLE + " WHERE archetype_name = ?";
final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE archetype_id = ?";
final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
