package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;
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
		
		List<Locais> lista = new ArrayList<Locais>();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM locais";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				

				rs = pst.executeQuery();
				

				while(rs.next()) {

					Locais lo = new Locais();
					lo.setId(rs.getInt(1));
					lo.setLocal(rs.getString(2));
					lo.setDescricao(rs.getString(3));
					lo.setCriado_por(rs.getInt(4));
					lo.setCriado_em(rs.getDate(5));
					lista.add(lo);
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:"+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado, Mensagem:"+e.getMessage());		
			}
		
		finally {
			fechar();
		}
		
		return lista;
		
		
	}

	@Override
	public Locais listarID(Integer ID) {
		
		Locais lista = new Locais();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM locais WHERE id="+ID;
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				
				//Executar a consulta com o comando executeQuery, assim teremos
				//o comando Select sendo executado. O resultado da consulta é 
				//guardado em uma variável do tipo ResultSet(rs). Sempre que você
				//tiver uma consulta SELECT o retorno desta consulta deve ficar
				//em um ResultSet
				rs = pst.executeQuery();
				
				//O comando next() faz o cursor se movimentar para adiante
				//Dentro da tabela, quando há dados. Se não houver dados
				//O cursos não se movimenta e retorna falso, indicando
				//Que os dados da tabela acabaram.
				while(rs.next()) {
					//Todas as vezes que o laço while "roda", significa que o
					//comando next executou e assim foi para a próxima linha
					//E trazendo os dados dessa linha.
					//Para organizar e guardar os dados dos usuarios, criamos
					//um novo usuario da camada POJO e passamos todos os dados retornados
					//do RS para cada campo do usuario.
					//Depois adicionamos este usuário a lista de usuarios selecionados.
					Locais lo = new Locais();
					lo.setId(rs.getInt(1));
					lo.setLocal(rs.getString(2));
					lo.setDescricao(rs.getString(3));
					lo.setCriado_por(rs.getInt(4));
					lo.setCriado_em(rs.getDate(5));

					
					
					lista = lo;
					
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:"+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado, Mensagem:"+e.getMessage());		
			}
		
		finally {
			fechar();
		}
		
		return lista;
		
	}

}
