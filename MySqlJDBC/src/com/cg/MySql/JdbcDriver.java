package com.cg.MySql;

import java.sql.*;

public class JdbcDriver {

	public static void main(String[] args) {
		
		try {
			//get connection to the database
			Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","ikram786md");
		//create  a statement
		Statement stmt=myCon.createStatement();
		//execute as sql query
		String sql="insert into books(tno,name,author) values(1,'kkr','ikr')";
		String sql1="insert into books(tno,name,author) values(2,'mi','irf')";
		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql1);
		ResultSet rs=stmt.executeQuery("select * from books");
		while(rs.next())
		{
			System.out.println(rs.getString("name")+" "+rs.getString("author"));
		}
		String sql2="delete from books where tno=2";
		stmt.executeUpdate(sql2);
		ResultSet rs1=stmt.executeQuery("select * from books");
		while(rs1.next())
		{
			System.out.println(rs1.getString("name")+" "+rs1.getString("author"));
		}
		String sql3="update books set author='srividya' where  tno=1";
		stmt.executeUpdate(sql3);
		ResultSet rs2=stmt.executeQuery("select * from books");
		while(rs2.next())
		{
			System.out.println(rs2.getString("name")+" "+rs2.getString("author"));
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }}
