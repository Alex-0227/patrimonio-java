/*
 *  O Pacote br.com.patrimonio.dao, armazena as classes, interfaces e enus relacionados
 *  a conexão com o banco de dados.
 */


package br.com.patrimonio.dao;

/*
 * Importação das classes e interfaces que serão utilizadas para estabelecer a conexão com o banco de 
 * dados e executar os comandos de SQL.
 * A interface Connection(Conexão) permite estabelecer a conexão com o banco de dados.
 * 
 * A interface DriveManager(Gerenciador de drive) permite fazer passagem dos dados de 
 * conexão, tais como:url do banco, usuário e senha e retorna a conexão estabelecida
 * com o banco.
 * 
 * A classe SQLException(tratamento de erro permite capturar o erro gerado ao tentar
 * executar um comando de SQL e exibir o erro na tela.
 * 
 * A interface ResultSet(Resultado Encontrado) é usada para guardar os retornos das
 * consultas SELECT.
 * 
 * A interface PreparedStatement é utilizada para executar comandos de sql que modificam
 * a estrutura das tabelas, tais como: INSERT, UPDATE , DELETE
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * A classe conexão é uma classe é uma classe abstrata gerada para permitir a conexão
 * com o banco de dados das classes que farão a seleção, inserção, atualização e deleção de dados no banco de dados.
 * Nesta classe temos duas funções: Abrir(Que abre a conexão com o banco de dados),Fechar(que fecha a conexão com o banco de dados).
 * 
 */
public abstract class Conexao {
	

	//O elemento con recebe uma conexão estabelecida com o banco de dados.
	//Portanto, ele deve ser do tipo Connection, assim estará preparado para receber a conexão com o banco.
	//Iniciamos o objeto Con como Null(nulo) para depois receber a conexão.
	
	public Connection con = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;
	/**
	 * O metodo abrir é utilizado para estabelecer a conexão com o banco de dados
	 *
	 * @return
	 * Retorna a conexão com o banco.
	 */
	public boolean abrir() {
		Boolean abriu = true;
		try {
			//Carregar o driver de comunicação com o banco de dados mysql
			//em tempo de execução será feita uma instância
			//Do Driver, que o torna um objeto.
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:5030/hakodb", "root", "123senac");
			
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar estabelecer a conexão com o banco de dados. Mensagem:"+se.getMessage());
			abriu = false;
		}
		catch(Exception ex) {
			System.out.println("Erro inesperado Mensagem:"+ex.getMessage());
			abriu = false;	
		}
		return abriu;
	}
	/**
	 * O metodo fechar realiza o fechamento da conexão com o banco de dados
	 * @return
	 * Retorna que o banco foi fechado ou não
	 */
	public Boolean fechar() {
		Boolean fechou = true;
		try {
			con.close();
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar fechar o banco de dados. Mensagem:"+se.getMessage());
		}
		catch(Exception ex) {
			System.out.println("Erro inesperado, Mensagem:"+ex.getMessage());
		}	
		return fechou;	
		
		
	}
						
}
