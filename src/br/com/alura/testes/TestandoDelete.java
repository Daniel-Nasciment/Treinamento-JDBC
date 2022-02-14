package br.com.alura.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestandoDelete {

	public static void main(String[] args) throws Exception {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection newConnection = connectionFactory.newConnection();

		PreparedStatement stm = newConnection.prepareStatement("delete from produto where id > 2");

		stm.execute();

		// RETORNA O NUMERO DE LINHAS QUE FORAM AFETADAS
		int linhasAfetadas = stm.getUpdateCount();

		System.out.println("Linhas afetadas: " + linhasAfetadas);

		stm.close();
		newConnection.close();
		
	}

}
