package com.cg.MySql;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class ProcedureCall {
		public static void main(String[] args) {
			 try {
		            //get connection to the database
				 String pdept = "Engineering";
				 int increaseAmount = 100000;
				 Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ikram786md");
				 PreparedStatement stmt = mycon.prepareCall("{call increase_salaries_for_department(?, ?)}");
				 stmt.setString(1, pdept);
				 stmt.setDouble(2, increaseAmount);
				 stmt.execute();
				 mycon.close();
				} catch (SQLException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				}
			 showSalaries("Engineering");
		}
		static void showSalaries(String department_name)  {
			
			try {
				//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","redapple");
				Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ikram786md");
				
				PreparedStatement stmt= mycon.prepareStatement("select id, salary from employees where department = ?");
				stmt.setString(1, department_name);
				ResultSet rs = stmt.executeQuery();
		        while(rs.next())
		        {
		            System.out.println(rs.getString("id")+" salary: "+rs.getString("salary"));
		            
		        }
			}
			catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}
	}

