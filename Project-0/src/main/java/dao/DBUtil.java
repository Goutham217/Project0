package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	// singleton design pattern
		static Connection conn;
			
		static {
			try {
				
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
		static Connection makeConnection() throws SQLException {
			
			String connectionUrl = "jdbc:postgresql://localhost:5432/bank";
			String userName = "postgres";
			String password = "1234";
			if(conn == null) {
				conn = DriverManager.getConnection(connectionUrl, userName, password);	
			}
			return conn;
		
		}
		
		public static void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
