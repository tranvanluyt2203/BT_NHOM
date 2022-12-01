package Controller;

import java.sql.*;

public class test {
	public static void main(String[] args) {
		String type = new String();
		try 
		{
			String username="admin01",password="admin01";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from account where username='"+username+"' and password='"+password+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				type=rs.getString(4);
			}
		} 
		catch (Exception e) 
		{
		}
		System.out.print(type);
	}

}
