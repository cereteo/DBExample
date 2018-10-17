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

public class ContinentsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IContinentsDao continentsDao = new ContinentsDaoImpl();
		List<Continents> continents = continentsDao.getAllContinents();

		request.setAttribute("continents", continents);
		request.getRequestDispatcher("TableDB.jsp").forward(request, response);
	}

} 
