package it.objectmethod.jdbc.dao;

import java.util.List;

import it.objectmethod.jdbc.model.City;

public interface ICityDao {
	
	public List<City> getAllCities(String country);
	
	public List<City> getSearchCity(String city);
	
	public boolean addCity(String cityName, int population, String Nation);
	
	public boolean modCity(String cityName, int population, String Nation, int id);
	
	public boolean delCity(int id);

}
