package br.com.alura.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametros {

	public static void main(String[] args) throws Exception {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection newConnection = connectionFactory.newConnection();

		newConnection.setAutoCommit(false);

		// USANDO PREPARESTATEMENT EVITAMOS SQL INJECTION, OS PARAMETROS SÃO PASSADOS
		// COMO "?"
		// O MESMO MANTEM O CÓDIGO SQL COMPILADO
		PreparedStatement stm = newConnection.prepareStatement("insert into produto(nome, descricao) values (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		adicionaProduto(stm, "iPhone 12", "iPhone 12 64GB preto");
		adicionaProduto(stm, "iPhone 13 PRO MAX", "iPhone 13 128GB verde");

		stm.close();
		newConnection.commit();
		newConnection.close();

	}

	private static void adicionaProduto(PreparedStatement stm, String nome, String descricao) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		ResultSet resultSet = stm.getGeneratedKeys();

		while (resultSet.next()) {
			int id = resultSet.getInt(1);

			System.out.println("Novo produto criado! ID: " + id);
		}

	}

}
