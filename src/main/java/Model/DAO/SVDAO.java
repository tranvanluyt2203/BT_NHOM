package Model.DAO;

import java.sql.*;
import java.util.ArrayList;

import Model.BEAN.SV;

public class SVDAO 
{
	public ArrayList<SV> getSVList()
	{
		ArrayList<SV> list_SV= new ArrayList<SV>();
		SV sv=new SV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from sv";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				sv.setid(rs.getString(1));
				sv.setname(rs.getString(2));
				sv.setage(rs.getInt(3));
				sv.setidgv(rs.getString(4));
				sv.setdiem(rs.getFloat(5));
				list_SV.add(sv);
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		
		return list_SV;
	}
	public SV getSV(String idgv)
	{
		SV sv=new SV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from SV where id='"+idgv+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				sv.setid(rs.getString(1));
				sv.setname(rs.getString(2));
				sv.setage(rs.getInt(3));
				sv.setidgv(rs.getString(4));
				sv.setdiem(rs.getFloat(5));
			}
		}
		catch (Exception e)
		{	
			System.out.print(e);
		}
		return sv;
	}
	public ArrayList<SV> getSVByIdgv(String idgv)
	{
		ArrayList<SV> list_SV= new ArrayList<SV>();
		SV sv=new SV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from sv where idgv='"+idgv+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				sv=new SV();
				sv.setid(rs.getString(1));
				sv.setname(rs.getString(2));
				sv.setage(rs.getInt(3));
				sv.setidgv(rs.getString(4));
				sv.setdiem(rs.getFloat(5));
				list_SV.add(sv);
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		return list_SV;
	}
	public void DelSV(String id)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="delete from sv where id='"+id+"'";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	public void UpdateInforSV(SV sv)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="update sv set name='"+sv.getname()+"', age='"+sv.getage()+"' where id='"+sv.getid()+"'";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	public void UpdateDiemSV(SV sv)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="update sv set diem='"+sv.getdiem()+"' where id='"+sv.getid()+"'";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	public SV SearchSV(String factor,String nfactor)
	{
		SV sv=new SV();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="select * from sv where "+factor+"='"+nfactor+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				sv.setid(rs.getString(1));
				sv.setname(rs.getString(2));
				sv.setage(rs.getInt(3));
				sv.setidgv(rs.getString(4));
				sv.setdiem(rs.getFloat(5));
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		return sv;
	}
	public void Add(SV sv)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bt_nhom","root","");
			Statement stmt=con.createStatement();
			String sql="insert into sv values ('"+sv.getid()+"','"+sv.getname()+"','"+sv.getage()+"','"+sv.getidgv()+"','"+sv.getdiem()+"')";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{	
			System.out.print(e);
		}
	}
}
