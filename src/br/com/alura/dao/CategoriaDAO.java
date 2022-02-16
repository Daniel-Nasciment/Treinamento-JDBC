package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

public class CategoriaDAO {

	private Connection con;

	public CategoriaDAO(Connection connection) {
		this.con = connection;

	}

	public List<Categoria> listar() throws Exception {

		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "select * from categoria";

		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				while (rs.next()) {

					Categoria c = new Categoria(rs.getInt(1), rs.getString(2));
					categorias.add(c);

				}

			}

		}

		return categorias;
	}

	public List<Categoria> listarComProdutos() throws Exception {

		Categoria ultima = null;

		List<Categoria> categorias = new ArrayList<Categoria>();

		// USAR O INNER JOIN EVITA DE AFETAR A PERFORMANCE DO BANCO COM O TERMO N + 1
		// EM UMA QUERY SÓ TRAGO OS RESULTADOS ESPERADOS SEM A NECESSIDADE DE CRIAR UM LAÇO
		// E A CADA REPETIÇÃO EXECUTAR UMA QUERY ESPECIFICA
		String sql = "select * from categoria c inner join produto p on c.id = p.id_categoria";

		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				while (rs.next()) {

					// E COM ESSA REGRA EU NÃO INSTANCIO MAIS DE UMA CATEGORIA COM O MESMO NOME
					if (ultima == null || !ultima.getNome().equals(rs.getString(2))) {

						ultima = new Categoria(rs.getInt(1), rs.getString(2));
						categorias.add(ultima);

					}

					Produto p = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));

					// A REFERENCIA "ultima" APONTA PARA UM OBJETO QUE JÁ ESTRA DENTRO DA LISTA DE CATEGORIAS
					ultima.getProdutos().add(p);

				}

			}

		}

		return categorias;

	}

}
