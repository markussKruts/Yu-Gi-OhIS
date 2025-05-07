package jtt.putans.dto;

public class Attribute {
private int attribute_id;
	public int getAttribute_id() {
	return attribute_id;
}


public void setAttribute_id(int attribute_id) {
	this.attribute_id = attribute_id;
}


	private String name;


public Attribute(String name) {
	this.name = name;
	
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


}
