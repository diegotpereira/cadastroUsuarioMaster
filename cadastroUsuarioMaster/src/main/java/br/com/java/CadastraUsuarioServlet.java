package br.com.java;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
	
	protected void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> listarUsuario = dao.getLista();
		request.setAttribute("listarUsuario", listarUsuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sucesso.jsp");
		dispatcher.forward(request, response);
	}

}
