package com.cg.MySql;



	
	import java.sql.*;
	public class Tcl {

	 

	    public static void main(String []args) {
	         //get connection to the database
	        Connection mycon;
	        try {
	            mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","ikram786md");
	            
	            //create a statement
	            Statement stmt= mycon.createStatement();
	            
	            //Sql query
	            
	            String s1="commit";
	            stmt.executeUpdate(s1);
	            
	            ResultSet rs=stmt.executeQuery("select * from books");
	            while(rs.next())
	            {
	                System.out.println(rs.getString("name")+" "+rs.getString("author"));
	                
	            }
	            System.out.println("---commit complete--------");
	            
	            String s6="insert into books(tno,name,author) values(5,'capg','pkc')";
	            stmt.executeUpdate(s6);
	            ResultSet rs5=stmt.executeQuery("select * from books");
	            while(rs5.next())
	            {
	                System.out.println(rs5.getString("name")+" "+rs5.getString("author"));
	               
	                
	            }
	            System.out.println("---------new column inserted");
	            
	            String s2="rollback";
	            stmt.executeUpdate(s2);
	            ResultSet rs2=stmt.executeQuery("select * from books");
	            while(rs2.next())
	            {
	                System.out.println(rs2.getString("name")+" "+rs2.getString("author"));
	                
	            }
	            System.out.println("---rollback complete--------");
	            
	            
	            
	            
	            
	            
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       
	    }
	    
	    
	 
}
