package com.cg.MySql;
    import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	public class StoringImageFileUsingBlob {

	 

	    public static void main(String[] args) throws SQLException, FileNotFoundException {
	        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ikram786md");
	              
	       String query = "INSERT INTO Articles(img_log) VALUES (?)";
	       PreparedStatement pstmt = con.prepareStatement(query);
	       
	       File image = new File("C:\\Users\\ikram.jpg");
	       FileInputStream inputStream = new FileInputStream(image);
	       
	       pstmt.setBinaryStream(1, inputStream);
	       pstmt.executeUpdate();
	       System.out.println("Image also inserted...");
	    }
	}


