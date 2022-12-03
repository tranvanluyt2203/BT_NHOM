package Controller;

import java.sql.*;

public class test {
	public static void main(String[] args) {
		String type=null;
		String username="user02";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from account where username='"+username+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				type=rs.getString(4);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println(type);
	}

}
