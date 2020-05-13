package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	String url = "jdbc:mysql://localhost:3306/bd_aula10";
	String login = "root";
	String senha = "1234";
	
	
	public void open()throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, login, senha);
	}
	
	public void close()throws Exception {
		con.close();
	}

}
