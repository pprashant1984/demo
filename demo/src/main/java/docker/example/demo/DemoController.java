package docker.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private List<String> list  = new ArrayList<>();
	static final String DB = "docker";	
    static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB;
    static final String USER = "root";
    static final String PASS = "root";

	
	public DemoController() {
//		list.add("Apple");
//		list.add("Orange");
//		list.add("Mango");
	}
	
	@GetMapping("/item")
	public List<String> getItems(){
		        // Establishing the connection
		        Connection conn = null;
		        Statement stmt = null;
		        
		        try {
		            // Register JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Open a connection
		            System.out.println("Connecting to database...");
		            conn = DriverManager.getConnection(DB_URL, USER, PASS);

		            // Create a statement object
		            stmt = conn.createStatement();

		            // Execute a query
		            String sql = "SELECT FirstName FROM firstdocker"; // Replace with your table name and columns
		            ResultSet rs = stmt.executeQuery(sql);

		            // Extract data from result set
		            while (rs.next()) {
		                
		                String name = rs.getString("FirstName");
		                
		                list.add(name);
		                // Display values
		                System.out.println("Name: " + name );
		            }

		            // Clean up the environment
		            rs.close();
		            stmt.close();
		            conn.close();
		            
		            
		        } catch (SQLException | ClassNotFoundException se) {
		            // Handle errors for JDBC
		            se.printStackTrace();
		        } finally {
		            try {
		                if (stmt != null) stmt.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		            try {
		                if (conn != null) conn.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		        }
				return list;
		    }
	
}
