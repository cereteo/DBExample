package it.objectmethod.jdbc.dao;

import java.util.List;

import it.objectmethod.jdbc.model.City;

public interface ICityDao {
	
	public List<City> getAllCities(String country);

}
