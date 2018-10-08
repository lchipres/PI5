package container;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqlConnector {
 
	private static final String url = "jdbc:mysql://localhost/cpremier";
 
	private static final String user = "root";
 
	private static final String password = "12345678";
	public static void main(String[] argv) {
 
		try {
			Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
 
