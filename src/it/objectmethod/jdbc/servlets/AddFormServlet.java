package it.objectmethod.jdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;
import it.objectmethod.jdbc.model.City;

public class AddFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String city = request.getParameter("city");
		int population = Integer.parseInt(request.getParameter("population"));
		String nation = request.getParameter("nation");
		
		ICityDao cityDao = new CityDaoImpl();
		boolean addCity = cityDao.addCity(city, population, nation);
		request.setAttribute("selectedCountry", session.getAttribute("selectedCountry"));
		request.setAttribute("validation", addCity);
		request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
	}
}
