package br.com.pswmaycon.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pessoas")
public class PessoaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("Charset", "UTF-8");
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/pessoa-crud?user=postgres&password=maycon&ssl=false";
			Connection conn = DriverManager.getConnection(url);

			Statement listarPessoas = conn.createStatement();
			String idp = req.getParameter("id");
			String sql;
			if(idp != null) {
				sql = "SELECT * from pessoa WHERE pessoaId = " + idp;
			}else {
				sql = "SELECT * from pessoa ORDER BY pessoaID";				
			}
				
			ResultSet result = listarPessoas.executeQuery(sql);

			while (result.next()) {
				long id = result.getLong("pessoaid");
				String nome = result.getString("nome");
				String sobrenome = result.getString("sobre_nome");
				resp.getOutputStream().println("[\nID: " + id + ";\nNome: " + nome + "\nSobreNome: " + sobrenome + "\n]");
			}

			conn.close();
			listarPessoas.close();
			result.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/pessoa-crud?user=postgres&password=maycon&ssl=false";
			Connection conn = DriverManager.getConnection(url);			
			Statement createEvent = conn.createStatement();
			
			String id = req.getParameter("id");
			String nome = req.getParameter("nome");
			String sobrenome = req.getParameter("sobre_nome");

			String sql = String.format("INSERT INTO pessoa VALUES (%s,'%s', '%s')", id, nome, sobrenome);
			System.out.println(sql);

			createEvent.executeUpdate(sql);

			conn.close();
			createEvent.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/pessoa-crud?user=postgres&password=maycon&ssl=false";
			Connection conn = DriverManager.getConnection(url);			
			Statement createEvent = conn.createStatement();
			
			String id = req.getParameter("id");

			String sql = String.format("DELETE FROM pessoa WHERE pessoaid = %s", id);
			System.out.println(sql);

			createEvent.executeUpdate(sql);

			conn.close();
			createEvent.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/pessoa-crud?user=postgres&password=maycon&ssl=false";
			Connection conn = DriverManager.getConnection(url);			
			Statement createEvent = conn.createStatement();
			
			String id = req.getParameter("id");
			String nome = req.getParameter("nome");
			String sobrenome = req.getParameter("sobre_nome");
			String sql = "";
			if(nome == null) {
				sql = String.format("UPDATE pessoa SET sobre_nome = '%s' WHERE pessoaid = %s", sobrenome, id );				
			}
			if(sobrenome == null) {
				sql = String.format("UPDATE pessoa SET nome = '%s' WHERE eventoid = %s", nome, id);								
			}
			if(nome != null && sobrenome != null) {
				sql = String.format("UPDATE pessoa SET nome = '%s', sobre_nome = '%s' WHERE pessoaid = %s" , nome, sobrenome, id);								
			}
			System.out.println(sql);

			createEvent.executeUpdate(sql);

			conn.close();
			createEvent.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}

}
