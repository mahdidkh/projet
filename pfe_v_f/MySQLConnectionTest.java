import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/tronsport_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username = "root";
            String password = "";
            
            // Establish the connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute a query to check tables
            System.out.println("Checking tables...");
            ResultSet tables = statement.executeQuery("SHOW TABLES");
            
            // Print the tables
            System.out.println("Tables in the database:");
            while (tables.next()) {
                System.out.println(tables.getString(1));
            }
            
            // Close the connection
            connection.close();
            System.out.println("\nDatabase connection closed.");
            
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
