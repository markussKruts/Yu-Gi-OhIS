package jtt.putans.dto;

public class Archetype {
	private int archetype_id;
	public int getArchetype_id() {
		return archetype_id;
	}


	public void setArchetype_id(int archetype_id) {
		this.archetype_id = archetype_id;
	}


	private String name;


	public Archetype(String name) {
		this.name = name;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	}
