package br.com.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ConnectionFactory;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException, Exception {

		
		try (Connection con = new ConnectionFactory().newConnection()){
			
			CategoriaDAO dao = new CategoriaDAO(con);
			
			dao.listar().forEach(c -> System.out.println(c));
			
		}
		
	}

}
