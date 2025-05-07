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
		setBounds(100, 100, 1461, 794);
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
		
		JLabel raceL = new JLabel("Race: ");
		raceL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		raceL.setBounds(605, 451, 218, 66);
		contentPane.add(raceL);
		
		JLabel typeL = new JLabel("Type: ");
		typeL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typeL.setBounds(605, 374, 218, 66);
		contentPane.add(typeL);
		
		JLabel archL = new JLabel("Archetype: ");
		archL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		archL.setBounds(605, 605, 218, 66);
		contentPane.add(archL);
		
		JLabel atkL = new JLabel("ATK: ");
		atkL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		atkL.setBounds(917, 374, 218, 66);
		contentPane.add(atkL);
		
		JLabel defL = new JLabel("DEF: ");
		defL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defL.setBounds(917, 451, 218, 66);
		contentPane.add(defL);
		
		JLabel lvlL = new JLabel("Level: ");
		lvlL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lvlL.setBounds(917, 528, 218, 66);
		contentPane.add(lvlL);
		
		JLabel lblSetsTheCard = new JLabel("Sets the card is in: \\n");
		lblSetsTheCard.setVerticalAlignment(SwingConstants.TOP);
		lblSetsTheCard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSetsTheCard.setBounds(1145, 374, 278, 353);
		contentPane.add(lblSetsTheCard);
		
	    // Base URL for the APIs
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
            
            // Get the JSON response9
            String jsonResponse = response.body();
            
            // Parse the JSON data
            JSONObject jsonObject = new JSONObject(jsonResponse);
            
            // For demonstration, let's priant out the card name and other info
            System.out.println("Card Name: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("name"));
            nameL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("name"));
            System.out.println("Type: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("type"));
            typeL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("type"));
            System.out.println("Description: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("desc"));
            descL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("desc"));
            System.out.println("Attribute: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("attribute"));
            attributeL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("attribute"));
            raceL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("race"));
            archL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("archetype"));
            atkL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("atk"));
            defL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("def"));
            lvlL.setText(jsonObject.getJSONArray("data").getJSONObject(0).getString("level"));
            System.out.println("Set names: ");
            JSONArray j = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("card_sets");
            List<String> setUrls = new ArrayList<>();
            for (int i = 0; i < j.length(); i++) {
				setUrls.add(j.getJSONObject(i).getString("set_code"));
			}
            String url = "https://images.ygoprodeck.com/images/cards/" + jsonObject.getJSONArray("data").getJSONObject(0).getInt("id") + ".jpg";
            BufferedImage image = downloadImage(url);
            Image scaledImage = image.getScaledInstance(470, 575, Image.SCALE_SMOOTH);
    		JLabel lblNewLabel = new JLabel(new ImageIcon(scaledImage));;
    		lblNewLabel.setBounds(38, 11, 470, 575);
    		contentPane.add(lblNewLabel);

    	    for (String s : setUrls) {
        	    HttpRequest requestSet = HttpRequest.newBuilder()
            	        .uri(URI.create("https://db.ygoprodeck.com/api/v7/cardsetsinfo.php?setcode=" + s))
            	        .build();
        	    HttpClient clientSet = HttpClient.newHttpClient();
        	    HttpResponse<String> responseSet = clientSet.send(requestSet, HttpResponse.BodyHandlers.ofString());
                
                // Get the JSON response9
                String jsonResponseSet = responseSet.body();
                
                // Parse the JSON data
                JSONObject jsonObjectSet = new JSONObject(jsonResponseSet);

                System.out.println(jsonObjectSet.getString("set_name"));
                lblSetsTheCard.setText(jsonObjectSet.getString("set_name"));
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	    
	}
    public static BufferedImage downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);  // Create a URL object from the image URL
        return ImageIO.read(url);     // Download and return the image as a BufferedImage
    }
}
