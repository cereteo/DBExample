package it.objectmethod.jdbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;
import it.objectmethod.jdbc.model.City;

@WebServlet("/SaveCityServlet")
public class SaveCityServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String cityName = request.getParameter("city");
		int population = Integer.parseInt(request.getParameter("population"));
		String nation = request.getParameter("nation");
		
		City city = new City();
		city.setId(id);
		city.setName(cityName);
		city.setPopulation(population);
		city.setCountryCode(nation);
		
		int success = 0;
		ICityDao cityDao = new CityDaoImpl();
		if(id>0) {
			success = cityDao.modCity(city);
		} else {
			success = cityDao.addCity(city);
		}
		
		
		request.setAttribute("selectedCountry", session.getAttribute("selectedCountry"));
		request.setAttribute("validation", success>0?"OK":"KO");
		request.getRequestDispatcher("CitiesServlet").forward(request, response);
	}
}
