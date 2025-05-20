package jtt.putans.dao;

import java.sql.SQLException;

import jtt.putans.dao.base.GenericDAO;
import jtt.putans.dto.Card;
import jtt.putans.dto.Price;

public interface  PriceDAO extends GenericDAO<Price> {
	final String TABLE = "price";
	Price getByCard(Card card) throws SQLException;
	Price getByPrice(int price) throws SQLException;
}
