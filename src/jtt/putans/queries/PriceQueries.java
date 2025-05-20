package jtt.putans.queries;

public interface PriceQueries {
 final String TABLE = "price";
	
	
	final String QUERY_INSERT_1 = "INSERT INTO " + TABLE + "(card_id, price) VALUES (?,?)";
	
	final String QUERY_UPDATE = "UPDATE " + TABLE + " SET card_id = ? , price = ?  WHERE price_id = ?";

	final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE attribute_name = ?";

	final String QUERY_GET_ID = "SELECT price_id FROM " + TABLE + " WHERE card_id = ?, price = ?";
	final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE price_id = ?";
	final String QUERY_GET_BY_CARD = "SELECT * FROM " + TABLE + " WHERE card_id = ?";
	final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
