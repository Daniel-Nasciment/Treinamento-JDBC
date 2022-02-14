package br.com.alura.testes;

import java.sql.Connection;
import java.sql.Statement;

public class TestandoDelete {

	public static void main(String[] args) throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection newConnection = connectionFactory.newConnection();

		Statement stm = newConnection.createStatement();
		
		
		stm.execute("delete from produto where id > 2");
		
		// RETORNA O NUMERO DE LINHAS QUE FORAM AFETADAS
		int linhasAfetadas = stm.getUpdateCount();
		
		System.out.println("Linhas afetadas: " + linhasAfetadas);
		
	}
	
}
