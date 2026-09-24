package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.patrimonio.pojo.Locais;

public class DAOLocais extends Conexao implements CRUD<Locais> {

	@Override
	public String cadastrar(Locais obj) {
		String msg = "Cadastro realizado";

		try {
			if (abrir()) {

				String localInsert = "INSERT INTO locais(nome, descricao, criado_por) VALUES (?, ?, ?)";

				pst = con.prepareStatement(localInsert);

				pst.setString(1, obj.getLocal());
				pst.setString(2, obj.getDescricao());
				pst.setInt(3, obj.getCriado_por());

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
	public Boolean atualizar(Locais obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Locais> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locais listarID(Integer ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
