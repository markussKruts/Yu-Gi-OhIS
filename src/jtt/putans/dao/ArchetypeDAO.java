package jtt.putans.dao;

import java.sql.SQLException;

import jtt.putans.dao.base.GenericDAO;
import jtt.putans.dto.Archetype;


public interface ArchetypeDAO extends GenericDAO<Archetype> {
	final String TABLE = "archetype";
	Archetype getByName(String name) throws SQLException;
}
