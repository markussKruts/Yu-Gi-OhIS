package jtt.putans;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;


public class MainClass {
	public static void main(String args[]) {
	    // Base URL for the API
	    String apiUrl = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=Pot%20Of%20Greed";

	    // Create an HttpClienta
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
            
            // For demonstration, let's print out the card name and other info
            System.out.println("Card Name: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("name"));
            System.out.println("Type: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("type"));
            System.out.println("Description: " + jsonObject.getJSONArray("data").getJSONObject(0).getString("desc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
