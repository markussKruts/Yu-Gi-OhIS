package jtt.putans.queries;

public class RaritiesQueries {
	private final String TABLE = "rarities";
	
	
	final String QUERY_INSERT_1 = "INSERT INTO " + TABLE + "(rarity_name) VALUES (?)";
	
	final String QUERY_UPDATE = "UPDATE " + TABLE + " SET rarity_name = ?  WHERE rarity_id = ?";

	final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE rarity_name = ?";

	final String QUERY_GET_ID = "SELECT rarity_id FROM " + TABLE + " WHERE rarity_name = ?";
	final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE rarity_id = ?";
	final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
