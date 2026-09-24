package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Usuarios;

public class DAOCurso extends Conexao implements CRUD<Cursos> {

	@Override
	public String cadastrar(Cursos obj) {

		String msg = "Cadastro realizado";

		// =====================================================
		// VALIDAÇÃO DOS CAMPOS
		// =====================================================

		if (obj == null) {
			return "Não foi possível cadastrar: curso inválido.";
		}

		if (obj.getNome() == null || obj.getNome().trim().isEmpty()) {
			return "Não foi possível cadastrar: informe o nome do curso.";
		}

		if (obj.getSigla() == null || obj.getSigla().trim().isEmpty()) {
			return "Não foi possível cadastrar: informe a sigla do curso.";
		}

		if (obj.getCriado_por() == null) {
			return "Não foi possível cadastrar: selecione o usuário.";
		}

		try {

			if (abrir()) {

				String cursoInsert =
						"INSERT INTO cursos(nome,sigla,criado_por) "
						+ "VALUES(?,?,?)";

				pst = con.prepareStatement(cursoInsert);

				pst.setString(
						1,
						obj.getNome().trim()
				);

				pst.setString(
						2,
						obj.getSigla().trim()
				);

				pst.setInt(
						3,
						obj.getCriado_por()
				);

				int i = pst.executeUpdate();

				if (i == 0) {

					msg = "Não foi possível cadastrar o curso.";
				}

			} else {

				msg = "Não foi possível abrir o banco.";
			}

		} catch (SQLException se) {

			msg =
					"Erro ao tentar cadastrar o curso. Mensagem: "
					+ se.getMessage();
		}

		return msg;
	}

	@Override
	public Boolean atualizar(Cursos obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cursos> listar() {
		
		List<Cursos> lista = new ArrayList<Cursos>();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM cursos";
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
					Cursos cu = new Cursos();
					cu.setId(rs.getInt(1));
					cu.setNome(rs.getString(2));
					cu.setSigla(rs.getString(3));
					cu.setCriado_por(rs.getInt(4));
					cu.setCriado_em(rs.getDate(5));
					lista.add(cu);
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
	public Cursos listarID(Integer ID) {
		
		Cursos lista = new Cursos();
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
					Cursos cu = new Cursos();
					cu.setId(rs.getInt(1));
					cu.setNome(rs.getString(2));
					cu.setSigla(rs.getString(3));
					cu.setCriado_por(rs.getInt(4));
					cu.setCriado_em(rs.getDate(5));
					
					
					lista = cu;
					
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
