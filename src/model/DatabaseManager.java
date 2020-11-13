package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class DatabaseManager 
{
	private String dburl = "jdbc:mysql://localhost:3306/user_db";
	private String dbuname = "user";
	private String dbpassword = "mysql";
	private String dbdriver = "com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public List<String> insert(Product product) 
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		List<String> result = new ArrayList<String>();//"Data entered succesfully";
		String sql = "insert into user_db.product values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getBarcode());
			ps.setString(2, product.getName());
			ps.setString(3, product.getColor());
			ps.setString(4, product.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.add("A product with the given barcode already exists.");
			result.add("\n Try another barcode.");
			
			return result;
		}
		
		result.add("Barcode:     " + product.getBarcode());
		result.add("Name:        " + product.getName());
		result.add("Color:       " + product.getColor());
		result.add("Description: " + product.getDescription());
		
		return result;
	}
}
