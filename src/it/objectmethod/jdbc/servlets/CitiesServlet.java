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

public class CitiesServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			String nation = request.getParameter("selectedCountry");
			if(nation == null) {
				nation = (String) session.getAttribute("selectedCountry");
			}
			session.setAttribute("selectedCountry", nation);
			
			ICityDao cityDao = new CityDaoImpl();
			List<City> cities = cityDao.getAllCities(nation);
			request.setAttribute("nation", nation);
			request.setAttribute("cities", cities);
			request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
			
	}
}
