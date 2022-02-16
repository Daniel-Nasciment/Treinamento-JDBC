package br.com.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ConnectionFactory;
import br.com.alura.model.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException, Exception {

		try (Connection con = new ConnectionFactory().newConnection()) {

			CategoriaDAO dao = new CategoriaDAO(con);

			List<Categoria> listarComProdutos = dao.listarComProdutos();

			listarComProdutos.forEach(c -> System.out.println(c));
			
		}

	}

}
