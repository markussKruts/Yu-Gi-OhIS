package jtt.putans.dao;

import java.sql.Date;
import java.sql.SQLException;

import jtt.putans.dao.base.GenericDAO;

import jtt.putans.dto.Set;

public interface SetDAO extends GenericDAO<Set> {
	final String TABLE = "set";
	Set getByName(String name) throws SQLException;
	Set getByCode(String code) throws SQLException;
	Set getByReleaseDate(Date date) throws SQLException;
}
