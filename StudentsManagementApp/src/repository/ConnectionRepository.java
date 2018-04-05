package repository;

import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class ConnectionRepository {
	
	public static java.sql.Connection getConnection() throws Exception{

		try{//Accessing driver from the JAR file
				Class.forName("com.mysql.jdbc.Driver");
				
				//Creating a variable for the connection called "con"
				java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement","george","George29.");
				
				//jdbc:myql://localhost/product is the database
				//root is the database user
				//no password	
				System.out.println("Connected");
				return con;
	} catch(Exception e){System.out.println(e); System.out.println("Error\n");}
	
	return null;
	}
	
	
	
}