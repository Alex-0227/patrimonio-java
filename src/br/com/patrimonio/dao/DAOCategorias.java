package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
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
		
		List<Categorias> lista = new ArrayList<Categorias>();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM categorias";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);

				rs = pst.executeQuery();

				while(rs.next()) {

					Categorias ca = new Categorias();
					ca.setId(rs.getInt(1));
					ca.setNome(rs.getString(2));
					ca.setDescricao(rs.getString(3));

					lista.add(ca);
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
	public Categorias listarID(Integer ID) {
		
		Categorias lista = new Categorias();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM cursos WHERE id="+ID;
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
					Categorias ca = new Categorias();
					ca.setId(rs.getInt(1));
					ca.setNome(rs.getString(2));
					ca.setDescricao(rs.getString(3));

					
					
					lista = ca;
					
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
