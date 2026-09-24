package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Perfil;
import br.com.patrimonio.pojo.Usuarios;

public class DAOUsuario extends Conexao implements IUsuario<Usuarios>{

	@Override
	public String cadastrar(Usuarios obj) {
		String msg = "Usuário cadastrado!";
		//Tentar abrir a conexão com o banco de dados
		try {
			if(abrir()) {
				//O processo de cadastro é usar o comando Insert
				//Do mysql. Nós precisamos executar um comando na camada de aplicação.
				//Este comando é o PreparedStatement.
				
				//O comando preparedStatement irá executar o comando insert
				//e Cadastrar os dados na tabela usuários. Os valores foram
				// passados por parâmetro usando pontos de interrogação
				// para cada ponto na tabela há um ponto de interrogação correspondente.
				//das formas de evitar a injeção de SQL(SQLinjection)
				pst = con.prepareStatement("INSERT INTO usuarios(nome_usuarios,email_usuarios,senha_hash_usuarios,perfil_usuarios,ativo_usuarios)VALUES(?,?,?,?,?)");
				//Abaixo, os parâmetros passados para cada pontos de interrogação
				//com seus respectivos valores
				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getEmail());
				pst.setString(3, obj.getSenha_hash());
				pst.setString(4, obj.getPerfil().toString());
				pst.setBoolean(5,obj.getAtivo());
				
				
				//Estamos executando a consulta e obtendo o retorno desta execução.
				//Se retornar 0 (Zero), então não houve cadastro; caso contrário, cadastrou
				int i = pst.executeUpdate();
				
				if(i < 1) {
					msg = "Não foi possivel cadastrar";
				}
				
			}
			else {
				msg = "Conexão Fechada";
			}
		}
	catch(SQLException se) {
		msg = "Erro tentar cadastrar o usuário, Mensagem: "+se.getMessage();
				
	}
	catch(Exception ex) {
		msg = "Erro inesperado. Mensagem: "+ex.getMessage(); 
	}
	finally {
		fechar();
	}
	
		return msg;
	}

	@Override
	public Boolean atualizar(Usuarios obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios listarID(Integer ID) {
		
		Usuarios lista = new Usuarios();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM usuarios WHERE id="+ID;

				pst = con.prepareStatement(sql);

				rs = pst.executeQuery();
				

				while(rs.next()) {

					Usuarios us = new Usuarios();
					us.setId(rs.getInt(1));
					us.setNome(rs.getString(2));
					us.setEmail(rs.getString(3));
					
					us.setPerfil(
						    Perfil.valueOf(
						        rs.getString(5)
						    )
						);
					
					us.setAtivo(rs.getBoolean(6));
					us.setCriado_em(rs.getDate(7));
					us.setAtualizado_em(rs.getDate(8));
					
					lista = us;
					
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
	public String alterarSenha(String usuario, String nova_senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios logar(String usuario, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> listaAtivos() {
		
		List<Usuarios> lista = new ArrayList<Usuarios>();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM usuarios WHERE ativo_usuarios=1";
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
					Usuarios us = new Usuarios();
					us.setId(rs.getInt(1));
					us.setNome(rs.getString(2));
					us.setEmail(rs.getString(3));
					
					us.setAtivo(rs.getBoolean(6));
					us.setCriado_em(rs.getDate(7));
					us.setAtualizado_em(rs.getDate(8));
					
					lista.add(us);
					
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
