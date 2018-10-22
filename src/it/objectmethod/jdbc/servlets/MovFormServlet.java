package it.objectmethod.jdbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;

public class MovFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		int population = Integer.parseInt(request.getParameter("population"));
		String nation = request.getParameter("nation");
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(city);
		ICityDao cityDao = new CityDaoImpl();
		boolean addCity = cityDao.modCity(city, population, nation, id);
		//(nation == null)? null :
		request.setAttribute("validation", addCity);
		request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
	}
}