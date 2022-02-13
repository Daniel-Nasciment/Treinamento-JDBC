package br.com.alura.testes;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestandoConexao {

	public static void main(String[] args) throws Exception {

		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "97777");
		
		System.out.println("Conexão criada");
		
		connection.close();

	}

}
