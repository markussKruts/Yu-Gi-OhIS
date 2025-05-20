package jtt.putans.dao;

import java.sql.SQLException;

import jtt.putans.dao.base.GenericDAO;

import jtt.putans.dto.Rarities;

public interface RaritiesDAO extends GenericDAO<Rarities> {
	final String TABLE = "rarities";
	Rarities getByName(String name) throws SQLException;
}
