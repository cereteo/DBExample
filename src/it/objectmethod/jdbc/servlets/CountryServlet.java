package it.objectmethod.jdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		String continent = (request.getParameter("selectedContinent") != null) ? request.getParameter("selectedContinent"): (String) session.getAttribute("selectedContinent");
		if(continent != null) {
			session.setAttribute("selectedContinent", continent);
		};
		
		System.out.println(continent);
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = (continent == null)? null : countryDao.getAllCountryByContinent(continent);
		
		request.setAttribute("selectedContinent", continent);
		request.setAttribute("country", country);
		request.getRequestDispatcher("CountryTable.jsp").forward(request, response);
		

	}
}
