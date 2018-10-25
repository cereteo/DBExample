package it.objectmethod.jdbc.dao;

import java.util.List;

import it.objectmethod.jdbc.model.City;
import it.objectmethod.jdbc.model.Country;

public interface ICityDao {
	
	public List<City> getAllCities(String country);
	
	public City getCityById(int id);
	
	public List<City> getSearchCity(String city);
	
	public int addCity(City city);
	
	public int modCity(City city);
	
	public void movCities(String countryTo, int[] citiesCode);
	
	public int delCity(int id);

}
