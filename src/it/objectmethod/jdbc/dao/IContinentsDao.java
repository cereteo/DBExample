package it.objectmethod.jdbc.dao;
import java.util.List;

import it.objectmethod.jdbc.model.City;
import it.objectmethod.jdbc.model.Continents;

public interface IContinentsDao {

	public List<Continents> getAllContinents();
}
