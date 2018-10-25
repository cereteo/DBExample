package it.objectmethod.jdbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.jdbc.dao.ICityDao;
import it.objectmethod.jdbc.dao.ICountryDao;
import it.objectmethod.jdbc.dao.impl.CityDaoImpl;
import it.objectmethod.jdbc.dao.impl.CountryDaoImpl;

public class MovFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codeFrom = request.getParameter("nationFrom");
		String codeTo = request.getParameter("nationTo");
		
		ICountryDao countryDao = new CountryDaoImpl();
		countryDao.MoveCountry(codeTo, codeFrom);
		request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
	}
}