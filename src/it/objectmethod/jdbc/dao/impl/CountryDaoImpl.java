package it.objectmethod.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.jdbc.config.ConnectionFactory;
import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.IContinentsDao;
import it.objectmethod.jdbc.dao.ICountryDao;
import it.objectmethod.jdbc.model.Continents;
import it.objectmethod.jdbc.model.Country;

public class CountryDaoImpl implements ICountryDao{

	@Override
	public List<Country> getAllCountry() {
		Connection conn = ConnectionFactory.getConnection();
		Statement stmt = null;
		List<Country> ret = new ArrayList<Country>();
		try{
			stmt = conn.createStatement();
			String sql = "SELECT Continent, sum(SurfaceArea) totSurfaceArea, sum(Population) totPopulation FROM world.country\n" + 
					"GROUP BY Continent;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){

				Country c = new Country();
				c.setName(rs.getString("Name"));
				c.setSurfaceArea(Double.parseDouble(rs.getString("SurfaceArea")));
				c.setPopulation(Integer.parseInt(rs.getString("totPopulation")));
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
