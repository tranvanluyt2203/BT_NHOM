package Model.DAO;

import java.sql.*;
import java.util.ArrayList;

import Model.BEAN.GV;

public class GVDAO 
{
	public ArrayList<GV> getGVList()
	{
		ArrayList<GV> list_GV= new ArrayList<GV>();
		GV gv=new GV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from gv";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				gv = new GV();
				gv.setid(rs.getString(1));
				gv.setname(rs.getString(2));
				gv.setage(rs.getInt(3));
				gv.setlesson(rs.getString(4));
				list_GV.add(gv);
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		
		return list_GV;
	}
	public GV getGV(String idgv)
	{
		GV gv=new GV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from gv where id='"+idgv+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				gv.setid(rs.getString(1));
				gv.setname(rs.getString(2));
				gv.setage(rs.getInt(3));
				gv.setlesson(rs.getString(4));
			}
		}
		catch (Exception e)
		{	
			System.out.print(e);
		}
		return gv;
	}
	public void UpdateGV(GV gv)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="update gv set name='"+gv.getname()+"', age='"+gv.getage()+"', lesson='"+gv.getlesson()+"' where id='"+gv.getid()+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	public void DeleteGV(String id)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="delete from gv where id='"+id+"'";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	public GV SearchGV(String factor,String nfactor)
	{
		GV gv=new GV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from gv where "+factor+"='"+nfactor+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				gv.setid(rs.getString(1));
				gv.setname(rs.getString(2));
				gv.setage(rs.getInt(3));
				gv.setlesson(rs.getString(4));
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		return gv;
	}
	public void Add(GV gv)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="insert into gv values ('"+gv.getid()+"','"+gv.getname()+"','"+gv.getage()+"','"+gv.getlesson()+"')";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{	
			System.out.print(e);
		}
	}
}
