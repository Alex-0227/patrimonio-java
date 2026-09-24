package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.patrimonio.pojo.Categorias;

public class DAOCategorias extends Conexao implements CRUD<Categorias> {

	@Override
	public String cadastrar(Categorias obj) {
		String msg = "Cadastro realizado";

		try {
			if (abrir()) {

				String localInsert = "INSERT INTO categorias(nome, descricao) VALUES (?, ?)";

				pst = con.prepareStatement(localInsert);

				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getDescricao());
				

				int i = pst.executeUpdate();

				if (i < 0) {
					msg = "Não foi possível cadastrar o local";
				}
			}
			else {
				msg = "Não foi possível abrir o banco";
			}
		}
		catch (SQLException se) {
			msg = "Erro ao tentar cadastrar o local. Mensagem: " + se.getMessage();
		}

		return msg;
	}

	@Override
	public Boolean atualizar(Categorias obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorias> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorias listarID(Integer ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
