package br.com.alura.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestandoConexao {

	public static void main(String[] args) throws Exception {

		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "97777");
		
		// STATEMENT É UMA INTERFACE UTILIZADA PARA EXECUTAR COMANDOS SQL
		Statement stm = connection.createStatement();
		
		// A PARTIR DO STATEMENT É CRIADO O EXECUTE
		stm.execute("select * from produto");
		
		// A PARTIR DO RESULTSET POSSO ACESSAR OS RESULTADOS
		ResultSet resultSet = stm.getResultSet();
		
		while(resultSet.next()) {
		
			int id = resultSet.getInt("id");
			System.out.println(id);
			
			String nome = resultSet.getString("nome");
			System.out.println(nome);
			
			String descricao = resultSet.getString("descricao");
			System.out.println(descricao);
			
			
		}
		
		connection.close();

	}

}
