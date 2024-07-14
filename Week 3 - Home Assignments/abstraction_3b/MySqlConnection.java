package week3.homeassignments.abstraction_3b;

// MySqlConnection Abstract class implementing the DatabaseConnection interface
public abstract class MySqlConnection implements DatabaseConnection {
	
	// Abstract method declaration: executeQuery, to be implemented by subclasses
	public abstract void executeQuery();

    // Implementation of the connect method, which will be used to establish a connection to a database
    @Override
    public void connect() {
        System.out.println("Connected to the database");
    }

    // Implementation of the disconnect method, which will be used to close a connection to a database
    @Override
    public void disconnect() {
        System.out.println("Disconnected from the database");
    }

    // Implementation of the executeUpdate method, which will be used to execute an update query on a database
    @Override
    public void executeUpdate() {
        System.out.println("Executed an update query");
    }

}
