package week3.homeassignments.abstraction_3b;

// Interface declaration, defining a blueprint for classes that implement it
public interface DatabaseConnection {
	
	// Method declaration: connect, to be implemented by classes that implement this interface
	public void connect();
	
	// Method declaration: disconnect, to be implemented by classes that implement this interface
	public void disconnect();

	// Method declaration: executeUpdate, to be implemented by classes that implement this interface
	public void executeUpdate();
	
}
