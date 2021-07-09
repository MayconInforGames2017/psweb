package br.upe.progaramacaoweb.apipokemon.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.upe.progaramacaoweb.apipokemon.model.Usuario;

@WebServlet("/v1/usuario")
public class UsuarioController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson json = new Gson();
		Usuario usuario = json.fromJson(reqBody, Usuario.class);

		Usuario.addUser(usuario);

		resp.sendError(201, "Usuário cadastrado com sucesso!");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson json = new Gson();
		String usuario = json.toJson(Usuario.getUsuarios());
		
		resp.getWriter().write(usuario);
	}
	
}
