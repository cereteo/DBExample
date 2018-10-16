package it.objectmethod.JDBCTutorial.JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBExampleServlet extends HttpServlet{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/World";
	
	static final String USER = "root";
	static final String PASS = "root";

	public static ArrayList<CityDBClass> DataFromDB() {
	//public static void main(String[] args) {
		
		   Connection conn = null;
		   Statement stmt = null;
		   ArrayList<CityDBClass> ret = new ArrayList<CityDBClass>();
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String Name = null;
		      String District = null;
		      int Population = 0;
		      String sql;
		      sql = "SELECT Name, District, Population FROM world.city";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		    	   //Retrieve by column name
		    	  Name  = rs.getString("Name");
		    	  District  = rs.getString("District");
		          Population = rs.getInt("Population");
		          //Display values
		         // System.out.print("ID: " + Name);
		          //System.out.print(", Age: " + District);
		          //System.out.print(", First: " + Population);
		          ret.add(new CityDBClass(Name, District, Population));
		       }
		       //STEP 6: Clean-up environment
		       rs.close();
		       stmt.close();
		       conn.close();
		    }catch(SQLException se){
		       //Handle errors for JDBC
		       se.printStackTrace();
		    }catch(Exception e){
		       //Handle errors for Class.forName
		       e.printStackTrace();
		    }finally{
		       //finally block used to close resources
		       try{
		          if(stmt!=null)
		             stmt.close();
		       }catch(SQLException se2){
		       }// nothing we can do
		       try{
		          if(conn!=null)
		             conn.close();
		       }catch(SQLException se){
		          se.printStackTrace();
		       }//end finally try
		    }//end try
		   
		   System.out.println(ret.size());
		    System.out.println("Goodbye!");
		    
		   
		    
		    return ret;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("data", DataFromDB());
	    request.getRequestDispatcher("TableDB.jsp").forward(request, response);
	}
	
	
	
	
	
	
} 
