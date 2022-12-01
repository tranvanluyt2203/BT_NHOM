package Model.DAO;
import java.sql.*;
import java.util.ArrayList;

import Model.BEAN.Account;

public class AccountDAO
{
	public boolean isExistAccount(String userName, String password)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from account";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				if (userName.equals(rs.getString(2))&&password.equals(rs.getString(3)))
				{
					return true;
				}
			}
			return false;
		}
		catch (Exception e)
		{
			System.out.print(e);
			return false;
		}
	}
	public String getTypeAccount(String username,String password)
	{
		String type = new String();
		try 
		{
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
		return type;
	}
	public ArrayList<Account> getAccountList()
	{
		ArrayList<Account> list_account= new ArrayList<Account>();
		Account account=new Account();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from account";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				account = new Account();
				account.setid(rs.getString(1));
				account.setusername(rs.getString(2));
				account.setpassword(rs.getString(3));
				account.settype(rs.getString(4));
				list_account.add(account);
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		
		return list_account;
	}
}