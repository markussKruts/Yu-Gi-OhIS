package jtt.putans.dto;

public class Card_Type {
	private int card_type;
	private String name;


	public Card_Type(String name) {
		this.name = name;
		
	}


	public int getCard_type() {
		return card_type;
	}


	public void setCard_type(int card_type) {
		this.card_type = card_type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	}

