package it.objectmethod.jdbc.dao;
import java.util.List;

import it.objectmethod.jdbc.model.Country;

public interface ICountryDao {

	public List<Country> getAllCountryByContinent(String continent);
	
	public List<Country> getAllCountry();
	
	public List<Country> MoveCountry(String CodeTo, String CodeFrom);
}
