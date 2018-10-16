package it.objectmethod.jdbc.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.IContinentsDao;
import it.objectmethod.jdbc.dao.ICountryDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;
import it.objectmethod.jdbc.dao.impl.ContinentsDaoImpl;
import it.objectmethod.jdbc.dao.impl.CountryDaoImpl;
import it.objectmethod.jdbc.model.City;
import it.objectmethod.jdbc.model.Continents;
import it.objectmethod.jdbc.model.Country;

public class DBExampleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICityDao cityDao = new CityDaoImpl();
		List<City> cities = cityDao.getAllCities();
		
		IContinentsDao continentsDao = new ContinentsDaoImpl();
		List<Continents> continents = continentsDao.getAllContinents();
		
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = countryDao.getAllCountry();
		
		request.setAttribute("cities", cities);
		request.setAttribute("continents", continents);
		request.setAttribute("country", country);
		
		request.getRequestDispatcher("TableDB.jsp").forward(request, response);
	}

} 
