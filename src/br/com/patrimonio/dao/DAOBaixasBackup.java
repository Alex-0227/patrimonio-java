//package br.com.patrimonio.dao;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import br.com.patrimonio.pojo.Baixas;
//
//public class DAOBaixas extends Conexao implements CRUD<Baixas> {
//
//	@Override
//	public String cadastrar(Baixas obj) {
//
//		String msg = "Cadastro realizado";
//
//		// =====================================================
//		// VALIDAÇÃO DOS CAMPOS
//		// =====================================================
//
//		if (obj == null) {
//			return "Não foi possível cadastrar: baixa inválida.";
//		}
//
//		if (obj.getPatrimonio_id() == null) {
//			return "Não foi possível cadastrar: selecione o patrimônio.";
//		}
//
//		if (obj.getUsuario_registro_id() == null) {
//			return "Não foi possível cadastrar: selecione o usuário.";
//		}
//
//		if (obj.getTipo_baixa() == null) {
//			return "Não foi possível cadastrar: selecione o tipo de baixa.";
//		}
//
//		if (obj.getMotivo() == null || obj.getMotivo().trim().isEmpty()) {
//			return "Não foi possível cadastrar: informe o motivo da baixa.";
//		}
//
//		try {
//
//			if (abrir()) {
//
//				String baixaInsert =
//						"INSERT INTO baixas_patrimoniais("
//						+ "patrimonio_id,"
//						+ "usuario_registro_id,"
//						+ "tipo_baixa,"
//						+ "motivo,"
//						+ "valor_recuperado,"
//						+ "documento_comprobatorio,"
//						+ "data_baixa"
//						+ ") VALUES(?,?,?,?,?,?,?)";
//
//				pst = con.prepareStatement(baixaInsert);
//
//				pst.setInt(
//						1,
//						obj.getPatrimonio_id()
//				);
//
//				pst.setInt(
//						2,
//						obj.getUsuario_registro_id()
//				);
//
//				pst.setString(
//						3,
//						obj.getTipo_baixa().toString()
//				);
//
//				pst.setString(
//						4,
//						obj.getMotivo().trim()
//				);
//
//				if (obj.getValor_recuperado() != null) {
//
//					pst.setDouble(
//							5,
//							obj.getValor_recuperado()
//					);
//
//				} else {
//
//					pst.setNull(
//							5,
//							java.sql.Types.DOUBLE
//					);
//				}
//
//				if (obj.getDocumento_comprobatorio() != null
//						&& !obj.getDocumento_comprobatorio().trim().isEmpty()) {
//
//					pst.setString(
//							6,
//							obj.getDocumento_comprobatorio().trim()
//					);
//
//				} else {
//
//					pst.setNull(
//							6,
//							java.sql.Types.VARCHAR
//					);
//				}
//
//				if (obj.getData_baixa() != null) {
//
//					pst.setDate(
//							7,
//							obj.getData_baixa()
//					);
//
//				} else {
//
//					pst.setDate(
//							7,
//							new java.sql.Date(
//									System.currentTimeMillis()
//							)
//					);
//				}
//
//				int i =
//						pst.executeUpdate();
//
//				if (i == 0) {
//
//					msg =
//							"Não foi possível cadastrar a baixa.";
//
//				}
//
//			} else {
//
//				msg =
//						"Não foi possível abrir o banco.";
//			}
//
//		} catch (SQLException se) {
//
//			msg =
//					"Erro ao tentar cadastrar a baixa. Mensagem: "
//					+ se.getMessage();
//		}
//
//		return msg;
//	}
//
//	@Override
//	public Boolean atualizar(Baixas obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deletar(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Baixas> listar() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Baixas listarID(Integer ID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
