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
		IContinentsDao continentsDao = new ContinentsDaoImpl();
		List<Continents> continents = continentsDao.getAllContinents();
		
		String continent = request.getParameter("selectedContinent");
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = (continent == null)? null : countryDao.getAllCountry(continent);
		
		String nation = request.getParameter("selectedCountry");
		ICityDao cityDao = new CityDaoImpl();
		List<City> cities = (nation == null)? null :cityDao.getAllCities(nation);
		
		request.setAttribute("continents", continents);
		request.setAttribute("country", country);
		request.setAttribute("cities", cities);
		if(nation != null) {
			request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
		} else if (country != null) {
			request.getRequestDispatcher("CountryTable.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("TableDB.jsp").forward(request, response);
		}		
	}

} 
