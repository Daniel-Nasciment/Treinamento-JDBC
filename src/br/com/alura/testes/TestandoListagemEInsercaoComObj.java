package br.com.alura.testes;

import java.sql.Connection;
import java.util.List;

import br.com.alura.dao.ConnectionFactory;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.model.Produto;

public class TestandoListagemEInsercaoComObj {

	public static void main(String[] args) throws Exception {

		Produto mesa = new Produto("Mesa Gamer", "Mesa Gamer grande vermelha");

		try (Connection con = new ConnectionFactory().newConnection()) {

			ProdutoDAO dao = new ProdutoDAO(con);
			dao.salvar(mesa);
			
			List<Produto> listar = dao.listar();

			listar.forEach(p -> System.out.println(p));
			
		}

	}

}
