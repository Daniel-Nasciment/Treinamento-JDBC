package br.com.alura.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.modelo.Produto;

public class TestandoInsercaoComObj {

	public static void main(String[] args) throws Exception {

		Produto mesa = new Produto("Mesa Gamer", "Mesa Gamer grande vermelha");

		try (Connection con = new ConnectionFactory().newConnection()) {

			String sql = "insert into produto(nome, descricao) values (?, ?)";
			// NESSE CASO SETEI O AUTO COMMIT COMO FALSE 
			con.setAutoCommit(false);

			// CASO ACONTEÇA ALGUMA EXCEÇÃO, NO CATCH FAREI ROLLBACK DA TRANSAÇÃO
			try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				stm.setString(1, mesa.getNome());
				stm.setString(2, mesa.getDescricao());

				stm.execute();

				try (ResultSet result = stm.getGeneratedKeys()) {

					while (result.next()) {
						mesa.setId(result.getInt(1));
						System.out.println(mesa);
					}

					con.commit();

				}

			} catch (Exception e) {

				con.rollback();

			}

		}

	}

}
