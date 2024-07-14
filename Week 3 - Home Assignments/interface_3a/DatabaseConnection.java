package week3.homeassignments.interface_3a;

// Public interface declaration, defining a blueprint for classes that implement it
public interface DatabaseConnection {
	
	// Method declaration: connect, which will be used to establish a connection to a database
	public void connect();
	
	// Method declaration: disconnect, which will be used to close a connection to a database
	public void disconnect();

	// Method declaration: executeUpdate, which will be used to execute an update query on a database
	public void executeUpdate();

}
