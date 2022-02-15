package br.com.alura.testes;

public class TestandoPoolConexoes {

	public static void main(String[] args) throws Exception {

		ConnectionFactory con = new ConnectionFactory();
		
		
		for (int i = 0; i < 15; i++) {

			// NESSE CASO SERA PROCESSADO AS 10 REQUISIÇÕES
			// AS REQUISIÇÕES POSTERIORES VÃO SER ATENDIDAS APÓS AS ATUALMENTE ABERTAS SE FECHAREM
			con.newConnection();
			
			System.err.println(i);
			
		}
		
		
	}

}
