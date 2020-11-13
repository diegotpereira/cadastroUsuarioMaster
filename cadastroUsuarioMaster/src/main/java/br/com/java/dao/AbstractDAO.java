package br.com.java.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
	
	protected Connection con;
	
	public AbstractDAO() {
		try {
			con = FabricaConexao.getInstance().getConexao();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	public abstract List<T> getLista();
	
	public abstract void adicionar(T objeto);

}
