package jtt.putans.dto;

public class Rarities {
	private int rarity_id;
private String name;


	public Rarities(String name) {
		this.name = name;
		
	}


	public int getRarity_id() {
		return rarity_id;
	}


	public void setRarity_id(int rarity_id) {
		this.rarity_id = rarity_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	}
