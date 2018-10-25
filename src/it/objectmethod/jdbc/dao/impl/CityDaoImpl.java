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
import it.objectmethod.sql.SQLFinder;

public class CityDaoImpl implements ICityDao{

	private List<City> doQueryWithStringParameter(String sql, String clause){
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
				c.setId(rs.getInt("Id"));
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
		String sql = SQLFinder.getSql("getAllCities");

		return doQueryWithStringParameter(sql, country);
	}
	
	
	/*String sql = "SELECT  c.Name, c.District, c.Population, c.Id\n" + 
					"		, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital \n" + 
					"		FROM  world.city c left join world.country cc  on c.ID = cc.Capital \n" + 
					"		where c.Id = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			
			rs = stmt.execute();*/
	
	public City getCityById(int id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		City c = new City();
		try{
			stmt = conn.prepareStatement("SELECT  c.Name, c.District, c.Population, c.Id\n" + 
					"		, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital \n" + 
					"		FROM  world.city c left join world.country cc  on c.ID = cc.Capital \n" + 
					"		where c.Id = ?");

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				c.setName(rs.getString("Name"));
				c.setPopulation(rs.getInt("Population"));
				c.setCapital(rs.getBoolean("isCapital"));
				c.setId(rs.getInt("Id"));
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

		return c;
	};
	
	@Override
	public List<City> getSearchCity(String city) {

		String sql = SQLFinder.getSql("getSearchCity");
		return doQueryWithStringParameter(sql, "%"+city+"%");
	}
	
	public boolean addCity(String cityName, int population, String Nation){
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean rs = false;
		try{
			
			String sql = "INSERT INTO city (Name, Population, CountryCode) VALUES (?, ?, (SELECT  Code FROM  world.country c  WHERE c.Code = ?));";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, cityName);
			stmt.setInt(2, population);
			stmt.setString(3, Nation);
			
			System.out.println(sql+"  "+Nation);
			rs = stmt.execute();
			
			System.out.println(rs);
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

		return rs;
	}

	public boolean modCity(String cityName, int population, String Nation, int id){
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean rs = false;
		try{
			
			String sql = "UPDATE world.city SET name= ? , population = ?, CountryCode = ? WHERE ID = ?;";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, cityName);
			stmt.setInt(2, population);
			stmt.setString(3, Nation);
			stmt.setInt(4, id);
			
			System.out.println(sql+"  "+id);
			rs = stmt.execute();
			
			System.out.println(rs);
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

		return rs;
	}

	public boolean movCity(String countryTo, int citiesCode) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean rs = false;
		try{
			
			String sql = "UPDATE world.city c LEFT JOIN world.country cc ON c.ID = cc.Capital\n" + 
					"SET c.CountryCode=? , cc.Capital = null\n" + 
					"where c.Id = ?;";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, countryTo);
			stmt.setInt(2, citiesCode);
			
			rs = stmt.execute();
			
			System.out.println(rs);
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

		return rs;
	}
	
	public void movCities(String countryTo, int[] citiesCode) {
		for(int i=0; i<citiesCode.length; i++) {
			movCity(countryTo, citiesCode[i]);
		}
	}
	
public boolean delCity(int id){
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean rs = false;
		try{
			
			String sql = "DELETE FROM world.city WHERE ID = ?;";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			
			System.out.println(sql+"  "+id);
			rs = stmt.execute();
			
			System.out.println(rs);
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

		return rs;
	}

}
