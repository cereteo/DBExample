package it.objectmethod.jdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.ICountryDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;
import it.objectmethod.jdbc.dao.impl.CountryDaoImpl;
import it.objectmethod.jdbc.model.City;
import it.objectmethod.jdbc.model.Country;

public class OpenMovFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String country = request.getParameter("nation");
		System.out.println(country);
		
		ICityDao cityDao = new CityDaoImpl();
		List<City> city = cityDao.getAllCities(country);
		ICountryDao coutryDao = new CountryDaoImpl();
		List<Country> nation = coutryDao.getAllCountry();
		
		request.setAttribute("nation", nation);
		request.setAttribute("city", city);
		request.getRequestDispatcher("movCityForm.jsp").forward(request, response);
	}
}