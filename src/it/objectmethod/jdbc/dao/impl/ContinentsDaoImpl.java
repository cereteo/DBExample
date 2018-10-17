package it.objectmethod.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.jdbc.config.ConnectionFactory;
import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.IContinentsDao;
import it.objectmethod.jdbc.model.Continents;

public class ContinentsDaoImpl implements IContinentsDao{

	@Override
	public List<Continents> getAllContinents() {
		Connection conn = ConnectionFactory.getConnection();
		Statement stmt = null;
		List<Continents> ret = new ArrayList<Continents>();
		try{
			stmt = conn.createStatement();
			String sql = "SELECT Continent, sum(SurfaceArea) totSurfaceArea, sum(Population) totPopulation FROM world.country\n" + 
					"GROUP BY Continent;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){

				Continents c = new Continents();
				c.setContinent(rs.getString("continent"));
				
				c.setTotSurfaceArea(Double.parseDouble(rs.getString("totSurfaceArea")));
				c.setTotPopulation(Long.parseLong(rs.getString("totPopulation")));
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

}
