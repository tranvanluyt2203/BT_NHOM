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
	public int Num_GV()
	{
		int dem=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select count(*) from account where type='admin'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) 
			{
				dem=rs.getInt(1);
			}
		}
		catch (Exception e) 
		{
			System.out.print(e);
		}
		return dem;
	}
	public int Num_SV()
	{
		int dem=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select count(*) from account where type='user'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) 
			{
				dem=rs.getInt(1);
			}
		}
		catch (Exception e) 
		{
			System.out.print(e);
		}
		return dem;
	}
	public void Add(Account account)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="insert into account values ('"+account.getid()+"','"+account.getusername()+"','"+account.getpassword()+"','"+account.gettype()+"')";
			stmt.executeUpdate(sql);
			
		}catch (Exception e) 
		{
			System.out.print(e);
		}
	}
	public String GetidByUsername(String username)
	{
		String id=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from account where username='"+username+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getString(1);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return id;
	}
	public String GettypeByUsername(String username)
	{
		String type=null;
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
		return type;
	}
	public void DelAccount(String id)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="delete from account where id='"+id+"'";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}