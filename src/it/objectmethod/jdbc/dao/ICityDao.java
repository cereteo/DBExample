package it.objectmethod.jdbc.dao;

import java.util.List;

import it.objectmethod.jdbc.model.City;
import it.objectmethod.jdbc.model.Country;

public interface ICityDao {
	
	public List<City> getAllCities(String country);
	
	public City getCityById(int id);
	
	public List<City> getSearchCity(String city);
	
	public boolean addCity(String cityName, int population, String Nation);
	
	public boolean modCity(String cityName, int population, String Nation, int id);
	
	public boolean delCity(int id);

}
