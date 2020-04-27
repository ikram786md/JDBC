package com.cg.MySql;


		import java.sql.*;
		public class inOutParameters {
		public static void main(String[] args)throws SQLException {
		CallableStatement myStmt= null;
		ResultSet myRes=null;
		try {
		Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ikram786md");
		//prepare statement
		String theDepartment="Engineering";
		//prepare the stored procedure call

		myStmt=myCon.prepareCall("{call get_count_for_department(?,?)}");
		myStmt.setString(1, theDepartment);
		myStmt.registerOutParameter(2,Types.INTEGER);
		System.out.println("calling stored procedure. get_count_for_department('"+ theDepartment+"',?)");
		myStmt.execute();
		System.out.println("finished calling stored procedure");
		int theCount= myStmt.getInt(2);
		System.out.println("the count is"+ theCount);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		

	}

}
