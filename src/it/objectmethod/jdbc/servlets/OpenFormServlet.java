package it.objectmethod.jdbc.servlets;

import java.io.IOException;
import java.util.List;
import java.util.jar.Attributes.Name;

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

public class OpenFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		if(id > 0) {
			
			ICityDao cityDao = new CityDaoImpl();
			City city = cityDao.getCityById(id);			
			request.setAttribute("city", city);	
		}		
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = countryDao.getAllCountry();
		request.setAttribute("country", country);
		request.getRequestDispatcher("cityForm.jsp").forward(request, response);
	}
}