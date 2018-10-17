package it.objectmethod.jdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;
import it.objectmethod.jdbc.model.City;

public class SearchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("search");
		System.out.println(city);
		ICityDao cityDao = new CityDaoImpl();
		List<City> cities = cityDao.getSearchCity(city);

		request.setAttribute("cities", cities);
		request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
	}
}