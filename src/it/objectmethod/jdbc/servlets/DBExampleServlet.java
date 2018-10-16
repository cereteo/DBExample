package it.objectmethod.jdbc.servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.model.City;

public class DBExampleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/world";

	static final String USER = "root";
	static final String PASS = "root";

	public static ArrayList<City> dataFromDB() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<City> ret = new ArrayList<City>();
		try{

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT Name, District, Population FROM world.city";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

				City c = new City();
				c.setName(rs.getString("Name"));
				c.setDistrict(rs.getString("District"));
				c.setPopulation(rs.getInt("Population"));
				ret.add(c);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{

				if(conn!=null) {
					conn.close();
				}

			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		return ret;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cities", dataFromDB());
		request.getRequestDispatcher("TableDB.jsp").forward(request, response);
	}






} 
