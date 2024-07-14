package week3.homeassignments.interface_3a;

// JavaConnection class declaration, implementing the DatabaseConnection interface
public class JavaConnection implements DatabaseConnection {

	// Implementation of the connect method, which will be used to establish a connection to a database
	@Override
	public void connect() {
		System.out.println("Connecting to the database");
	}
	
	// Implementation of the disconnect method, which will be used to close a connection to a database
	@Override
	public void disconnect() {
		System.out.println("Disconnecting from the database");
	}
	
	// Implementation of the executeUpdate method, which will be used to execute an update query on a database
	@Override
	public void executeUpdate() {
		System.out.println("Executing update");
	}
	
}
