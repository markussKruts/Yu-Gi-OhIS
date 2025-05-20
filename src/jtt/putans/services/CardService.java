package jtt.putans.services;

public class CardService {
private final String TABLE = "cards";
	
	private final String QUERY_INSERT = "INSERT INTO " + TABLE + "(card_id, name, description, attack, defense, level, attribute_id, race_id, rarity_id, archetype_id, frame_type_id, card_type_id, image_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String QUERY_UPDATE_1 = "UPDATE " + TABLE + " SET prieksmets_id = ? WHERE skolotajs_id = ? AND  prieksmets_id = ? AND kurss_id = ?  AND datums = ? AND laiks = ?";
	private final String QUERY_UPDATE_2 = "UPDATE " + TABLE + " SET skolotajs_id = ? WHERE skolotajs_id = ? AND  prieksmets_id = ? AND kurss_id = ?  AND datums = ? AND laiks = ?";
	private final String QUERY_UPDATE_3 = "UPDATE " + TABLE + " SET kurss_id = ?, skolotajs_id = ? WHERE skolotajs_id = ? AND  prieksmets_id = ? AND kurss_id = ?  AND datums = ? AND laiks = ?";
	private final String QUERY_UPDATE_4 = "UPDATE " + TABLE + " SET kabinets_id = ?, skolotajs_id = ? WHERE skolotajs_id = ? AND  prieksmets_id = ? AND kurss_id = ?  AND datums = ? AND laiks = ?";
	private final String QUERY_UPDATE_5 = "UPDATE " + TABLE + " SET datums = STR_TO_DATE(?, '%Y-%m-%d'), skolotajs_id = ? WHERE skolotajs_id = ? AND  prieksmets_id = ? AND kurss_id = ?  AND datums = ? AND laiks = ?";
	private final String QUERY_UPDATE_6 = "UPDATE " + TABLE + " SET laiks = ?, skolotajs_id = ? WHERE skolotajs_id = ? AND  prieksmets_id = ? AND kurss_id = ?  AND datums = ? AND laiks = ?";
	
	private final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE name = ? AND description = ? AND attack = ? AND defense = ? AND level = ? AND attribute_id = ? AND race_id = ? AND rarity_id = ? AND archetype_id = ? AND frame_type_id = ? AND card_type_id = ? AND image_id = ?";
	
	private final String QUERY_GET_ID = "SELECT id FROM " + TABLE + " WHERE skolotajs_id = ? AND prieksmets_id = ? AND kurss_id = ? AND datums = ? AND laiks = ?";
	private final String QUERY_GET_BY_ID = "SELECT * FROM " + TABLE + " WHERE id = ?";
	private final String QUERY_GET_BY_SKOLOTAJS = "SELECT * FROM " + TABLE + " WHERE skolotajs_id = ?";
	private final String QUERY_GET_BY_PRIEKSMETS = "SELECT * FROM " + TABLE + " WHERE prieksmets_id = ?";
	private final String QUERY_GET_BY_KURSS = "SELECT * FROM " + TABLE + " WHERE kurss_id = ?";
	private final String QUERY_GET_BY_KABINETS = "SELECT * FROM " + TABLE + " WHERE kabinets_id = ?";
	private final String QUERY_GET_BY_DATUMS = "SELECT * FROM " + TABLE + " WHERE datums = ?";
	private final String QUERY_GET_BY_LAIKS = "SELECT * FROM " + TABLE + " WHERE laiks = ?";
	private final String QUERY_GET_ALL = "SELECT * FROM " + TABLE;
}
