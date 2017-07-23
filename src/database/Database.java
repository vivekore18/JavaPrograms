package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public Statement getstatement() throws SQLException, ClassNotFoundException{
			Connection con;
			Statement stmt = null;
		
			try{
		
		String driver = "com.mysql.jdbc.driver";
		String connection ="jdbc:mysql://localhost:3306/customer";
		String username ="root";
		String Password ="toor";
		
			Class.forName(driver);
			con= DriverManager.getConnection(connection, username, Password);
			stmt =con.createStatement();
					
	} catch (Exception e) {
		e.printStackTrace();
	}
	return stmt;
}

	public void insertData(String query) throws ClassNotFoundException, SQLException {
		Statement sta = getstatement();
		sta.executeUpdate(query);
	}

	public ResultSet getData(String query) throws ClassNotFoundException, SQLException {
		ResultSet data = getstatement().executeQuery(query);
		return data;
	}

	public ResultSet updateData(String query) throws ClassNotFoundException, SQLException {
		ResultSet data = getstatement().executeQuery(query);
		return data;

	}

}
