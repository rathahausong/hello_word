package controler;

import java.sql.Connection;

import JDBC.IConnection;

public class Main {
	public static void main(String[] args) {
		
		try {
			IConnection.CONNECTION();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
