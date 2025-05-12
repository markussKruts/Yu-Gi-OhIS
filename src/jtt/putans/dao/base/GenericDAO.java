package jtt.putans.dao.base;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	int insert(T value) throws SQLException;
	int update(T value) throws SQLException;
	int delete(T value) throws SQLException;
	int getID(T value) throws SQLException;
	T getByID(int id) throws SQLException;
	List<T> getAllData() throws SQLException;
}
