package br.com.alura.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.dao.ConnectionFactory;

public class TestandoInsercao {

	public static void main(String[] args) throws Exception {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection newConnection = connectionFactory.newConnection();

		Statement stm = newConnection.createStatement();

		stm.execute("insert into produto (nome, descricao) values ('Notebook Gamer', 'Notebook Gamer - Acer - 1TB')", Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = stm.getGeneratedKeys();

		while(resultSet.next()) {
			int id = resultSet.getInt(1);
		
			System.out.println("Novo produto criado! ID: " + id);
		}
		
		stm.close();
		newConnection.close();
		
	}

}
