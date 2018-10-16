package it.objectmethod.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.jdbc.config.ConnectionFactory;
import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.model.City;

public class CityDaoImpl implements ICityDao{

	@Override
	public List<City> getAllCities() {
		Connection conn = ConnectionFactory.getConnection();
		Statement stmt = null;
		List<City> ret = new ArrayList<City>();
		try{
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

}
