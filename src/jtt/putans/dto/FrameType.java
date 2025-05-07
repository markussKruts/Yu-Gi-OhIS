package jtt.putans.dto;

public class FrameType {
	private int frame_type;
private	String frame_type_name;
	
	
	
	public FrameType(String name) {
		this.frame_type_name = name;
		
	}


	public int getFrame_type() {
		return frame_type;
	}


	public void setFrame_type(int frame_type) {
		this.frame_type = frame_type;
	}


	public String getFrame_type_name() {
		return frame_type_name;
	}


	public void setFrame_type_name(String frame_type_name) {
		this.frame_type_name = frame_type_name;
	}


	public String getName() {
		return frame_type_name;
	}


	public void setName(String name) {
		this.frame_type_name = name;
	}


	}

