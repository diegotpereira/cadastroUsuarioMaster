package br.com.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.dao.AbstractDAO;
import br.com.java.dao.UsuarioDAO;
import br.com.java.model.Usuario;




@WebServlet("/cadastraUsuario")
public class CadastraUsuarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AbstractDAO<Usuario> dao;
	
	public CadastraUsuarioServlet() {
		super();
		
		dao = new UsuarioDAO();
	}
	
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Usuario usuario = new Usuario((String) request.getParameter("nome"),
				(String) request.getParameter("endereco"));
		
		dao.adicionar(usuario);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.jsp");
		rd.forward(request, response);
	}

}
