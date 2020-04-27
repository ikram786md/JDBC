package com.cg.MySql;

 

import java.sql.*;

 

public class Employees {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        PreparedStatement mystmnt=null;
        ResultSet myres= null;
        
        
        try {
             //get connection to the database
            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ikram786md");
             //create a statement
            Statement stmt= mycon.createStatement();
            //prepared statements
            mystmnt = mycon.prepareStatement("select * from employees where salary >? or  department=? or email=?");

 

             //Set the parameters 
              mystmnt.setDouble(1,75000);
              mystmnt.setString(2,"Legal");
              mystmnt.setString(3,"...");
          //Execute the SQL query 
          myres = mystmnt.executeQuery();
          
          while(myres.next())
          {
              String lastName = myres.getString("last_name");
              String firstName = myres.getString("first_name");
              String department = myres.getString("department");
              double salary= myres.getDouble("salary");
              System.out.printf("%s,%s,%s,%.2f,\n",lastName,firstName,department,salary);
          }
          

 

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

 

}
 
		
	


