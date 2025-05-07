package jtt.putans.dto;

public class Race {
private int race_id;
private	String name;


	public Race(String name) {
		this.name = name;
		
	}


	public int getRace_id() {
		return race_id;
	}


	public void setRace_id(int race_id) {
		this.race_id = race_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	}
