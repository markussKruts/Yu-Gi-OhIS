package jtt.putans.dao;

import java.sql.SQLException;

import jtt.putans.dao.base.GenericDAO;
import jtt.putans.dto.Attribute;


public interface AttributeDAO extends GenericDAO<Attribute> {
	final String TABLE = "attribute";
	Attribute getByName(String name) throws SQLException;
}
