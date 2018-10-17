package it.objectmethod.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import it.objectmethod.jdbc.config.ConnectionFactory;
import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.model.City;

public class CityDaoImpl implements ICityDao{
	
	private List<City> DoQuery(String sql, String clause){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<City> ret = new ArrayList<City>();
		try{
			 stmt = conn.prepareStatement(sql);
			
			 stmt.setString(1, clause);
			 System.out.println(sql+"  "+clause);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){

				City c = new City();
				c.setName(rs.getString("Name"));
				c.setPopulation(rs.getInt("Population"));
				c.setCapital(rs.getBoolean("isCapital"));
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

	@Override
	public List<City> getAllCities(String country) {
		String sql = "SELECT  c.Name, c.District, c.Population, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital\n" + 
				"FROM  world.city c left join world.country cc  on c.ID = cc.Capital\n" + 
				"where c.CountryCode = ?";

		return DoQuery(sql, country);
	}

	@Override
	public List<City> getSearchCity(String city) {
		
		String sql = "SELECT  c.Name, c.District, c.Population, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital\n" + 
				"FROM  world.city c left join world.country cc  on c.ID = cc.Capital\n" + 
				"Where c.Name LIKE ?";
		return DoQuery(sql, "%"+city+"%");
	}

}
