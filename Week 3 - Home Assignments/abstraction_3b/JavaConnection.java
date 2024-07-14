package week3.homeassignments.abstraction_3b;

// JavaConnection class declaration extending the MySqlConnection class
public class JavaConnection extends MySqlConnection {

	// Implementation of the executeQuery method, which will be used to execute a query on a database
	@Override
	public void executeQuery() {
		System.out.println("Executing query");
	}
	
	public static void main(String[] args) {
		
		// Creating an object of the JavaConnection class
		JavaConnection javaConnection = new JavaConnection();
		
		// Calling the connect method
		javaConnection.connect(); //Inheriting from the MySqlConnection class which implements the DatabaseConnection interface
		
		// Calling the disconnect method
		javaConnection.disconnect(); //Inheriting from the MySqlConnection class which implements the DatabaseConnection interface
		
		// Calling the executeQuery method
		javaConnection.executeQuery(); //Inheriting from the MySqlConnection class but implementation is from the JavaConnection class
		
		// Calling the executeUpdate method
		javaConnection.executeUpdate(); //Inheriting from the MySqlConnection class which implements the DatabaseConnection interface
		
	}

}
