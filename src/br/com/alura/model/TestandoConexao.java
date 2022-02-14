package br.com.alura.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.testes.ConnectionFactory;

public class TestandoConexao {

	public static void main(String[] args) throws Exception {

		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection newConnection = connectionFactory.newConnection();
		
		Statement stm = newConnection.createStatement();
		
		stm.execute("select * from produto");
		
		ResultSet resultSet = stm.getResultSet();
		
		while(resultSet.next()) {
		
			int id = resultSet.getInt("id");
			System.out.println(id);
			
			String nome = resultSet.getString("nome");
			System.out.println(nome);
			
			String descricao = resultSet.getString("descricao");
			System.out.println(descricao);
			
			
		}
		
		newConnection.close();

	}

}
