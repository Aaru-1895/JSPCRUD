package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeUtil {
	
	public static Connection createConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EclinicTest","root","manek24#@tech");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}

}
