package week3.homeassignments.polymorphism;

// This class represents an APIClient, which can send requests to an API
public class APIClient {

	// This method sends a request to a specified endpoint
	public void sendRequest(String endpoint) {
		System.out.println("Sending request to: " + endpoint);
	}

	// This method sends a request to a specified endpoint with a request body and status
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("Sending request to: " + endpoint);
		System.out.println("Request body: " + requestBody);
		if (requestStatus) {
			System.out.println("Request status: SUCCESS");
		} else {
			System.out.println("Request status: FAILURE");
		}
	}
	
	public static void main(String[] args) {

		// Create an instance of the APIClient
		APIClient client = new APIClient();
		
		//Demonstrate Overloading with multiple arguments
		// Send a request to an endpoint without a request body or status
		client.sendRequest("https://example.com"); //Single Argument
		
		// Send a request to an endpoint with a request body and a successful status
		client.sendRequest("https://example.com", "Hello, World!", true); //Multiple Arguments
		
		// Send a request to an endpoint with a request body and a failed status
		client.sendRequest("https://example.com", "Hello, World!", false);
		
	}
}
