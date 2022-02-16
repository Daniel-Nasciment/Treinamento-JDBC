package br.com.alura.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {

		// CADA BANCO TEM SEU DATASOURCE (INTERFACE PARA CRIAR UM POOL DE CONEX�ES)
		// NESSE CASO N�O CRIAMOS NA M�O CADA CONX�O COM O BANCO
		// NO MYSQL UTILIZAMOS: ComboPooledDataSource PASSANDO A URL, USU�RIO E SENHA.
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("97777");
		
		// LIMITADOR DE REQUISI��ES
		comboPooledDataSource.setMaxPoolSize(10);

		// FEITO ISSO DECLARAMOS QUE O DATASOURCE � ESSE ComboPooledDataSource
		this.dataSource = comboPooledDataSource;

	}

	public Connection newConnection() throws Exception {

		// E A PARTIR DO DATASOURCE RECUPERAMOS A CONEX�O
		return dataSource.getConnection();

	}

}
