package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:8889/kagoyume_db","root","root");
//			System.out.println("DBに接続しました");
			return con;
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw new IllegalMonitorStateException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new IllegalMonitorStateException();
		}

	}
}
