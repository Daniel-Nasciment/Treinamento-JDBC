package br.com.alura.testes;

public class TestandoPoolConexoes {

	public static void main(String[] args) throws Exception {

		ConnectionFactory con = new ConnectionFactory();
		
		
		for (int i = 0; i < 15; i++) {

			// NESSE CASO SERA PROCESSADO AS 10 REQUISI��ES
			// AS REQUISI��ES POSTERIORES V�O SER ATENDIDAS AP�S AS ATUALMENTE ABERTAS SE FECHAREM
			con.newConnection();
			
			System.err.println(i);
			
		}
		
		
	}

}
