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

public class CountryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String continent = request.getParameter("selectedContinent");
	//	boolean back = Boolean.parseBoolean(request.getParameter("countryback"));
		
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = (continent == null)? null : countryDao.getAllCountry(continent);
		
		//System.out.println(back);
		request.setAttribute("country", country);
		request.getRequestDispatcher(/*(back)?"ContinentServlet":*/"CountryTable.jsp").forward(request, response);
		

	}
}
