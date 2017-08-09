package com.example;


import java.sql.*;

class DBDemo{

	public static void main(String[] s) {
		
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try{
			//Load jdbc driver in jvm
			Class.forName("com.mysql.jdbc.Driver");
			//Create a DB connection
			con = DriverManager.getConnection("jdbc:mysql://localhost" +
					":3306/cdk?useSSL=false","root","root");
			System.out.println("Connected to DB");	
			//Create a statement
			stm = con.createStatement();
			//Run the SQL query
			rs = stm.executeQuery("select * from employee_master");
			//Process the result
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double  sal = rs.getDouble(3);
				System.out.printf("ID : %s , Name : %s, Salary : %s%n",id,name,sal);	
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
					rs = null;	
				}
				if(stm!=null){
					stm.close();
					stm = null;	
				}
				if(con!=null){
					con.close();
					con = null;	
				}
				System.out.println("Disconnected from DB");	
			}catch(SQLException e){}
		}
	}

}