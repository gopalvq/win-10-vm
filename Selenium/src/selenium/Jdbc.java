package selenium;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Jdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//Connection URL syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/employee";
		
		//Database username
		String username = "root";
		
		//Database password
		String password = "password";
		
		//Query to execute
		String query = "select * from emp";
		String query1 = "INSERT INTO `employee`.`emp` (`Emp ID`, `Name`, `Age`) VALUES ('6', 'Kim', '55')";
		
		//load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Create connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		//Create statement Object
		Statement stmt = con.createStatement();
		
		//Inserting a row into table
		stmt.executeUpdate(query1);
		
		//Execute the SQL query and store the results in resultset
		ResultSet rs = stmt.executeQuery(query);
		
		//while loop to iterate through all data and print results
		while(rs.next()){
			String myId = rs.getString(1);
			String myName = rs.getString(2);
			String myAge = rs.getString(3);
			
			System.out.println(myId+" "+myName+" "+myAge);
		}
		
		
		
		//closing DB connection
		con.close();
		
		
	}
}
