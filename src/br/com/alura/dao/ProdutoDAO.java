package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.Produto;

public class ProdutoDAO {

	private Connection con;

	public ProdutoDAO(Connection connection) {
		this.con = connection;

	}

	public void salvar(Produto prod) throws Exception {

		String sql = "insert into produto(nome, descricao) values (?, ?)";

		con.setAutoCommit(false);

		try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, prod.getNome());
			stm.setString(2, prod.getDescricao());

			stm.execute();

			try (ResultSet result = stm.getGeneratedKeys()) {

				while (result.next()) {
					prod.setId(result.getInt(1));
					System.out.println(prod);
				}

				con.commit();

			}

		} catch (Exception e) {

			con.rollback();

		}

	}

	public List<Produto> listar() throws Exception {

		List<Produto> lista = new ArrayList<Produto>();
		String sql = "select * from produto";

		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.execute();

			try (ResultSet result = stm.getResultSet()) {

				while (result.next()) {

					Produto p = new Produto(result.getInt("id"), result.getString("nome"),
							result.getString("descricao"));

					lista.add(p);

				}

			}

		}

		return lista;

	}

}
