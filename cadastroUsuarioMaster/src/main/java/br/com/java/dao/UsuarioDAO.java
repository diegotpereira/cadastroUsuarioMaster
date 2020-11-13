package br.com.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.model.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario>{
	
	private List<Usuario> lista;
	
	public UsuarioDAO() {
		super();
		
		lista = new ArrayList<Usuario>();
		criaLista(lista);
	}
	 private void criaLista(List<Usuario> lista) {
//		    lista.add(new Usuario("Fernando", "Rua sem esquina, n. 1"));
//		    lista.add(new Usuario("Beatriz", "Rua com esquina, n. 4"));
		   }

	
	public List<Usuario> getLista() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement PS = con.prepareStatement("select * from usuario");
			ResultSet RES = PS.executeQuery();
			
			while (RES.next()) {
				Usuario usuario = new Usuario(RES.getString("nome"), RES.getString("endereco"));
				
				lista.add(usuario);
			}
			
			RES.close();
			PS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		return lista;
	}

	
	public void adicionar(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement PS = con.prepareStatement("insert into usuario(nome, endereco) values (?, ?)");
			PS.setString(1, usuario.getNome());	
			PS.setString(2, usuario.getEndereco());
			PS.executeUpdate();
			PS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}

}
