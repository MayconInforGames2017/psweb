package br.com.pswmaycon.empregado.model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pswmaycon.empregado.model.service.EmpregadoService;

@WebServlet(name = "EmpregadoServlet", urlPatterns = "/empregados")
public class EmpregadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1;

	private EmpregadoService empregadoService = null;

	@Override
	public void init() throws ServletException {
		empregadoService = new EmpregadoService();
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("empregados", empregadoService.getEmprego());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/empregados.jsp");
		dispatcher.forward(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
}
