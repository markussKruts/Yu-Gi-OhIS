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
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 1258, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameL = new JLabel("");
		nameL.setHorizontalAlignment(SwingConstants.CENTER);
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 50));
		nameL.setBounds(619, 11, 613, 130);
		contentPane.add(nameL);
		
		JLabel descL = new JLabel("Description: ");
		descL.setVerticalAlignment(SwingConstants.TOP);
		descL.setFont(new Font("Tahoma", Font.PLAIN, 25));
		descL.setBounds(605, 152, 627, 211);
		contentPane.add(descL);
		
		JLabel attributeL = new JLabel("Attribute: ");
		attributeL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		attributeL.setBounds(605, 528, 218, 66);
		contentPane.add(attributeL);
		
		JLabel lblNewLabel = new JLabel("Race: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(605, 451, 218, 66);
		contentPane.add(lblNewLabel);
		
		JLabel typeL = new JLabel("Type: ");
		typeL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typeL.setBounds(605, 374, 218, 66);
		contentPane.add(typeL);
		
		JLabel lblArchatype = new JLabel("Archetype: ");
		lblArchatype.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArchatype.setBounds(605, 605, 218, 66);
		contentPane.add(lblArchatype);
		
//	    // Base URL for the APIs
//		//this url is for a random card - https://db.ygoprodeck.com/api/v7/cardinfo.php?num=1&offset=0&sort=random&cachebust
//	    String apiUrl = "https://db.ygoprodeck.com/api/v7/cardinfo.php?num=1&offset=0&sort=random&cachebust";
//
//	    // Create an HttpClient
//	    HttpClient client = HttpClient.newHttpClient();
//	    
//	    // Create a request
//	    HttpRequest request = HttpRequest.newBuilder()
//	        .uri(URI.create(apiUrl))
//	        .build();
//	    try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            
//            // Get the JSON response9
//            String jsonResponse = response.body();
//            
//            // Parse the JSON data
//            JSONObject jsonObject = new JSONObject(jsonResponse);
//            
//            // For demonstration, let's priant out the card name and other info
//            System.out.println("Card Name: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("name"));
//            System.out.println("Type: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("type"));
//            System.out.println("Description: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("desc"));
//            System.out.println("Attribute: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("attribute"));
//            System.out.println("Set names: ");
//            JSONArray j = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("card_sets");
//            List<String> setUrls = new ArrayList<>();
//            for (int i = 0; i < j.length(); i++) {
//				setUrls.add(j.getJSONObject(i).getString("set_code"));
//			}
//            String url = "https://images.ygoprodeck.com/images/cards/" + jsonObject.getJSONArray("data").getJSONObject(0).getInt("id") + ".jpg";
//            BufferedImage image = downloadImage(url);
//            Image scaledImage = image.getScaledInstance(470, 575, Image.SCALE_SMOOTH);
//    		JLabel lblNewLabel = new JLabel(new ImageIcon(scaledImage));;
//    		lblNewLabel.setBounds(38, 11, 470, 575);
//    		contentPane.add(lblNewLabel);
//
//    	    for (String s : setUrls) {
//        	    HttpRequest requestSet = HttpRequest.newBuilder()
//            	        .uri(URI.create("https://db.ygoprodeck.com/api/v7/cardsetsinfo.php?setcode=" + s))
//            	        .build();
//        	    HttpClient clientSet = HttpClient.newHttpClient();
//        	    HttpResponse<String> responseSet = clientSet.send(requestSet, HttpResponse.BodyHandlers.ofString());
//                
//                // Get the JSON response9
//                String jsonResponseSet = responseSet.body();
//                
//                // Parse the JSON data
//                JSONObject jsonObjectSet = new JSONObject(jsonResponseSet);
//
//                System.out.println(jsonObjectSet.getString("set_name"));
//			}
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	    
	    
	}
    public static BufferedImage downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);  // Create a URL object from the image URL
        return ImageIO.read(url);     // Download and return the image as a BufferedImage
    }
}
