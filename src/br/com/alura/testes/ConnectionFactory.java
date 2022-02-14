package br.com.alura.testes;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection newConnection() throws Exception {

		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
				"root", "97777");

	}

}
