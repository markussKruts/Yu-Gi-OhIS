package jtt.putans;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;
import javax.swing.JLabel;

public class FreakMode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreakMode frame = new FreakMode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FreakMode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    // Base URL for the API
		//this url is for a random card - https://db.ygoprodeck.com/api/v7/cardinfo.php?num=1&offset=0&sort=random&cachebust
	    String apiUrl = "https://db.ygoprodeck.com/api/v7/cardinfo.php?num=1&offset=0&sort=random&cachebust";

	    // Create an HttpClient
	    HttpClient client = HttpClient.newHttpClient();
	    
	    // Create a request
	    HttpRequest request = HttpRequest.newBuilder()
	        .uri(URI.create(apiUrl))
	        .build();
	    try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Get the JSON response
            String jsonResponse = response.body();
            
            // Parse the JSON data
            JSONObject jsonObject = new JSONObject(jsonResponse);
            
            // For demonstration, let's priant out the card name and other info
            System.out.println("Card Name: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("name"));
            System.out.println("Type: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("type"));
            System.out.println("Description: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("desc"));
            String url = "https://images.ygoprodeck.com/images/cards/" + jsonObject.getJSONArray("data").getJSONObject(0).getInt("id") + ".jpg";
            BufferedImage image = downloadImage(url);
            Image scaledImage = image.getScaledInstance(470, 575, Image.SCALE_SMOOTH);
    		JLabel lblNewLabel = new JLabel(new ImageIcon(scaledImage));;
    		lblNewLabel.setBounds(38, 11, 470, 575);
    		contentPane.add(lblNewLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	    
	}
    public static BufferedImage downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);  // Create a URL object from the image URL
        return ImageIO.read(url);     // Download and return the image as a BufferedImage
    }

}
