package Controller;

import java.sql.*;

public class test {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select count(*) from account where type='user'";
			ResultSet rs=stmt.executeQuery(sql);
			int s = 0;
			while(rs.next()) {
				s = rs.getInt(1);
			}
			System.out.print(s);
			
		}
		catch (Exception e) 
		{
			System.out.print(e);
		}
	}

}
