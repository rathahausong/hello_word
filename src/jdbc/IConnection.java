package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class IConnection {
	public static Connection con = null;
	public static Connection CONNECTION() throws Exception{
		Class.forName("org.postgresql.Driver");
		String URL ="jdbc:postgresql://localhost:5432/mydb";
		String USER ="postgres";
		String PASSWORD="123";
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		return con;
	}
}
