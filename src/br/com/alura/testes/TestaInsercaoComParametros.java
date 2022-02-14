package br.com.alura.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestaInsercaoComParametros {
	
	public static void main(String[] args) throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection newConnection = connectionFactory.newConnection();

		// USANDO PREPARESTATEMENT EVITAMOS SQL INJECTION, OS PARAMETROS SÃO PASSADOS COMO "?"
		// O MESMO MANTEM O CÓDIGO SQL COMPILADO
		PreparedStatement stm = newConnection.prepareStatement("insert into produto(nome, descricao) values (?, ?)",  Statement.RETURN_GENERATED_KEYS);
		
		String nome = "SSD 1TB";
		String descricao = "SSD Kingston 1TB";
		
		// SETO OS PARAMETROS, PRIMEIRAMENTE O INDEX DE ACORDO COM OS "?" NA LINHA 17
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet resultSet = stm.getGeneratedKeys();

		while(resultSet.next()) {
			int id = resultSet.getInt(1);
		
			System.out.println("Novo produto criado! ID: " + id);
		}
		
		newConnection.close();
		
	}

}
