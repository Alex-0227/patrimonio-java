package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Baixas;
import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Status;
import br.com.patrimonio.pojo.TipoBaixa;

public class DAOBaixas extends Conexao implements CRUD<Baixas> {

	@Override
	public String cadastrar(Baixas obj) {

		String msg = "Cadastro realizado";

		// =====================================================
		// VALIDAÇÃO DOS CAMPOS
		// =====================================================

		if (obj == null) {
			return "Não foi possível cadastrar: baixa inválida.";
		}

		if (obj.getPatrimonio_id() == null) {
			return "Não foi possível cadastrar: selecione o patrimônio.";
		}

		if (obj.getUsuario_registro_id() == null) {
			return "Não foi possível cadastrar: selecione o usuário.";
		}

		if (obj.getTipo_baixa() == null) {
			return "Não foi possível cadastrar: selecione o tipo de baixa.";
		}

		if (obj.getMotivo() == null || obj.getMotivo().trim().isEmpty()) {
			return "Não foi possível cadastrar: informe o motivo da baixa.";
		}

		try {

			if (abrir()) {

				String baixaInsert =
						"INSERT INTO baixas_patrimoniais("
						+ "patrimonio_id,"
						+ "usuario_registro_id,"
						+ "tipo_baixa,"
						+ "motivo,"
						+ "valor_recuperado,"
						+ "documento_comprobatorio,"
						+ "data_baixa"
						+ ") VALUES(?,?,?,?,?,?,?)";

				pst = con.prepareStatement(baixaInsert);

				// =====================================================
				// PATRIMÔNIO
				// =====================================================

				pst.setInt(
						1,
						obj.getPatrimonio_id()
				);

				// =====================================================
				// USUÁRIO
				// =====================================================

				pst.setInt(
						2,
						obj.getUsuario_registro_id()
				);

				// =====================================================
				// TIPO DE BAIXA
				// =====================================================

				String tipoBaixa =
						obj.getTipo_baixa().name();

				/*
				 * O Java não permite "/" em identificadores de enum.
				 *
				 * Java:
				 * FurtoRoubo
				 *
				 * Banco:
				 * Furto/Roubo
				 */

				if (obj.getTipo_baixa() == TipoBaixa.FurtoRoubo) {

					tipoBaixa = "Furto/Roubo";
				}

				pst.setString(
						3,
						tipoBaixa
				);

				// =====================================================
				// MOTIVO
				// =====================================================

				pst.setString(
						4,
						obj.getMotivo().trim()
				);

				// =====================================================
				// VALOR RECUPERADO
				// =====================================================

				if (obj.getValor_recuperado() != null) {

					pst.setDouble(
							5,
							obj.getValor_recuperado()
					);

				} else {

					pst.setNull(
							5,
							java.sql.Types.DOUBLE
					);
				}

				// =====================================================
				// DOCUMENTO COMPROBATÓRIO
				// =====================================================

				if (obj.getDocumento_comprobatorio() != null
						&& !obj.getDocumento_comprobatorio().trim().isEmpty()) {

					pst.setString(
							6,
							obj.getDocumento_comprobatorio().trim()
					);

				} else {

					pst.setNull(
							6,
							java.sql.Types.VARCHAR
					);
				}

				// =====================================================
				// DATA DA BAIXA
				// =====================================================

				if (obj.getData_baixa() != null) {

					pst.setDate(
							7,
							obj.getData_baixa()
					);

				} else {

					pst.setDate(
							7,
							new java.sql.Date(
									System.currentTimeMillis()
							)
					);
				}

				// =====================================================
				// EXECUTA INSERT
				// =====================================================

				int i =
						pst.executeUpdate();

				if (i == 0) {

					msg =
							"Não foi possível cadastrar a baixa.";
				}

			} else {

				msg =
						"Não foi possível abrir o banco.";
			}

		} catch (SQLException se) {

			msg =
					"Erro ao tentar cadastrar a baixa. Mensagem: "
					+ se.getMessage();
		}

		return msg;
	}

	@Override
	public Boolean atualizar(Baixas obj) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Baixas> listar() {
		
		List<Baixas> lista = new ArrayList<Baixas>();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM baixas_patrimoniais";
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
					Baixas ba = new Baixas();
					ba.setId(rs.getInt(1));
					ba.setPatrimonio_id(rs.getInt(2));
					ba.setUsuario_registro_id(rs.getInt(3));
					
					
					String tipo_Baixa =
                            rs.getString("tipo_Baixa");

                    if (tipo_Baixa != null) {

                        ba.setTipo_baixa(
                                TipoBaixa.valueOf(tipo_Baixa)
                        );
                    }
					
					ba.setMotivo(rs.getString(5));
					ba.setValor_recuperado(rs.getDouble(6));
					ba.setDocumento_comprobatorio(rs.getString(7));
					ba.setData_baixa(rs.getDate(8));
					
					lista.add(ba);
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
	public Baixas listarID(Integer ID) {
		
		Baixas lista = new Baixas();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM baixas_patrimoniais WHERE id="+ID;
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
					Baixas ba = new Baixas();
					ba.setId(rs.getInt(1));
					ba.setPatrimonio_id(rs.getInt(2));
					ba.setUsuario_registro_id(rs.getInt(3));
					
					String tipo_Baixa =
                            rs.getString("tipo_Baixa");

                    if (tipo_Baixa != null) {

                        ba.setTipo_baixa(
                                TipoBaixa.valueOf(tipo_Baixa)
                        );
                    }
					
					ba.setMotivo(rs.getString(5));
					ba.setValor_recuperado(rs.getDouble(6));
					ba.setDocumento_comprobatorio(rs.getString(7));
					ba.setData_baixa(rs.getDate(8));
					
					lista = ba;
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