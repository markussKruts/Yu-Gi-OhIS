package jtt.putans.dao;

import java.sql.SQLException;

import jtt.putans.dao.base.GenericDAO;
import jtt.putans.dto.Race;



public interface RaceDAO extends GenericDAO<Race> {
	final String TABLE = "races";
	Booking getByCustomer(Customer customer) throws SQLException;
}
