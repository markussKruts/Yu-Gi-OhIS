package jtt.putans.dto;

public class Card_image {
	private int image_id;
	private String imageURL;



public int getImage_id() {
		return image_id;
	}



	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}



public Card_image(String imageURL) {
	this.imageURL = imageURL;
}



public String getImageURL() {
	return imageURL;
}



public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
}
}
