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
import it.objectmethod.jdbc.model.Country;

public class OpenFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = request.getParameter("form");

		System.out.println(form);
		String Dir = null;
		switch(form) {
			case "Add": 
				Dir = "addCityForm.jsp";
				break;
				
			case "Modify": 
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("population", Integer.parseInt(request.getParameter("population")));
				request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
				Dir = "modCityForm.jsp";
				break;
				
			case "Move": 
				Dir = "movCityForm.jsp";
				break;
		}
		
		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = countryDao.getAllCountry();
		request.setAttribute("country", country);
		System.out.println(Dir);
		request.getRequestDispatcher(Dir).forward(request, response);
	}
}