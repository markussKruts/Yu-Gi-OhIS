package jtt.putans.dto;

public class Price {
private Card card_id;
private int price;



public Price(Card card_id,int price) {
	this.card_id = card_id;
	this.price = price;
}



public Card getCard_id() {
	return card_id;
}



public void setCard_id(Card card_id) {
	this.card_id = card_id;
}



public int getPrice() {
	return price;
}



public void setPrice(int price) {
	this.price = price;
}
}
