package it.objectmethod.jdbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;

public class DelFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ICityDao cityDao = new CityDaoImpl();
		
		boolean addCity = cityDao.delCity(id); 
		request.setAttribute("validation", addCity);
		request.getRequestDispatcher("CitiesServlet").forward(request, response);
	}
}