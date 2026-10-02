package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Movimentacoes;
import br.com.patrimonio.pojo.TipoMov;

public class DAOMovimentacoes extends Conexao implements CRUD<Movimentacoes> {

    @Override
    public String cadastrar(Movimentacoes obj) {

        String msg = "Cadastro realizado";

        try {

            if (abrir()) {

                String movimentacaoInsert =
                        "INSERT INTO movimentacoes(" +
                        "patrimonio_id," +
                        "usuario_registro_id," +
                        "tipo_movimentacao," +
                        "responsavel_destino," +
                        "documento_responsavel," +
                        "data_saida," +
                        "data_prevista_retorno," +
                        "data_retorno_efetivo," +
                        "observacoes" +
                        ") VALUES (?,?,?,?,?,?,?,?,?)";

                pst = con.prepareStatement(movimentacaoInsert);

                pst.setInt(1, obj.getPatrimonio_id());

                pst.setInt(2, obj.getUsuario_registro_id());

                // O enum é armazenado como texto
                pst.setString(
                        3,
                        obj.getTipo_movimentacao().name()
                );

                pst.setString(
                        4,
                        obj.getResponsavel_destino()
                );

                pst.setString(
                        5,
                        obj.getDocumento_responsavel()
                );

                pst.setDate(
                        6,
                        obj.getData_saida()
                );

                pst.setDate(
                        7,
                        obj.getData_prevista_retorno()
                );

                pst.setDate(
                        8,
                        obj.getData_retorno_efetivo()
                );

                pst.setString(
                        9,
                        obj.getObservacoes()
                );

                int i = pst.executeUpdate();

                if (i == 0) {

                    msg =
                            "Não foi possível cadastrar a movimentação";
                }

            } else {

                msg =
                        "Não foi possível abrir o banco";
            }

        } catch (SQLException se) {

            msg =
                    "Erro ao tentar cadastrar a movimentação. Mensagem: "
                    + se.getMessage();
        }

        return msg;
    }

    @Override
    public Boolean atualizar(Movimentacoes obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String deletar(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
	public List<Movimentacoes> listar() {
		
		List<Movimentacoes> lista = new ArrayList<Movimentacoes>();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM movimentacoes";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				
				rs = pst.executeQuery();

				while(rs.next()) {
				
					Movimentacoes cu = new Movimentacoes();
					cu.setId(rs.getInt(1));
					cu.setPatrimonio_id(rs.getInt(2));
					cu.setUsuario_registro_id(rs.getInt(3));
					
					String tipo = rs.getString("tipo_movimentacao");

					System.out.println("TIPO DO BANCO = [" + tipo + "]");

					if (tipo != null) {
					    System.out.println("TENTANDO CONVERTER = [" + tipo + "]");

					    TipoMov tipoMov = TipoMov.valueOf(tipo);

					    cu.setTipo_movimentacao(tipoMov);
					}

                    
                    cu.setResponsavel_destino(rs.getString(5));
                    cu.setDocumento_responsavel(rs.getString(6));
                    cu.setData_saida(rs.getDate(7));
                    cu.setData_prevista_retorno(rs.getDate(8));
                    cu.setData_retorno_efetivo(rs.getDate(9));
                    cu.setObservacoes(rs.getString(10));
                    

					
					
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
	public Movimentacoes listarID(Integer ID) {
		
		Movimentacoes lista = new Movimentacoes();
		try {
			//Abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM movimentacoes WHERE id="+ID;
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				
				rs = pst.executeQuery();

				while(rs.next()) {
				
					Movimentacoes cu = new Movimentacoes();
					cu.setId(rs.getInt(1));
					cu.setPatrimonio_id(rs.getInt(2));
					cu.setUsuario_registro_id(rs.getInt(3));
					
					String tipo = rs.getString("tipo_movimentacao");

					System.out.println("TIPO DO BANCO = [" + tipo + "]");

					if (tipo != null) {
					    System.out.println("TENTANDO CONVERTER = [" + tipo + "]");

					    TipoMov tipoMov = TipoMov.valueOf(tipo);

					    cu.setTipo_movimentacao(tipoMov);
					}

                    
                    cu.setResponsavel_destino(rs.getString(5));
                    cu.setDocumento_responsavel(rs.getString(6));
                    cu.setData_saida(rs.getDate(7));
                    cu.setData_prevista_retorno(rs.getDate(8));
                    cu.setData_retorno_efetivo(rs.getDate(9));
                    cu.setObservacoes(rs.getString(10));
                    

					
					
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
