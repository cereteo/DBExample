package it.objectmethod.jdbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;

public class ModFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String city = request.getParameter("city");
		int population = Integer.parseInt(request.getParameter("population"));
		String nation = request.getParameter("nation");
		int id = Integer.parseInt(request.getParameter("id"));

		ICityDao cityDao = new CityDaoImpl();
		boolean addCity = cityDao.modCity(city, population, nation, id);

		request.setAttribute("selectedCountry", session.getAttribute("selectedCountry"));
		request.setAttribute("validation", addCity);
		request.getRequestDispatcher("CitiesServlet").forward(request, response);
	}
}