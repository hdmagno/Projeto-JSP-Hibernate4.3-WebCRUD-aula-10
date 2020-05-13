package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import persistence.UsuarioDao;

@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("gravar")) {
			gravar(request, response);
		} else if(cmd.equalsIgnoreCase("logar")) {
			logar(request, response);
		}
	}

	private void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario u = new Usuario(null, request.getParameter("email"), request.getParameter("senha"));
			Usuario resp = new UsuarioDao().findByLogin(u);
			if(resp != null) {
				request.setAttribute("msg", "Usuário Logado " + resp.getEmail());
			}else {
				request.setAttribute("msg", "Não logado");
			}
		} catch (Exception e) {
			request.setAttribute("msg", "Error: " +  e.getMessage());
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario u = new Usuario(null, request.getParameter("email"), request.getParameter("senha"));
			new UsuarioDao().create(u);
			request.setAttribute("msg", "Dados Gravados");
		} catch (Exception e) {
			request.setAttribute("msg", "Error " + e.getMessage());
		}
		request.getRequestDispatcher("sistema.jsp").forward(request, response);
	}
	

}
