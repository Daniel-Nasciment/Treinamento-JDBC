package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.model.Categoria;

public class CategoriaDAO {

	private Connection con;

	public CategoriaDAO(Connection connection) {
		this.con = connection;

	}

	public List<Categoria> listar() throws Exception {

		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "select * from categoria";

		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				while (rs.next()) {

					Categoria c = new Categoria(rs.getInt(1), rs.getString(2));
					categorias.add(c);

				}

			}

		}

		return categorias;
	}

}
