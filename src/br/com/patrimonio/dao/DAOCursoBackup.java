//package br.com.patrimonio.dao;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import br.com.patrimonio.pojo.Cursos;
//
//public class DAOCurso extends Conexao implements CRUD<Cursos> {
//
//	@Override
//	public String cadastrar(Cursos obj) {
//		String msg = "Cadastro realizado";
//		try {
//			if(abrir()) {
//				String cursoInsert= "INSERT INTO cursos(nome,sigla,criado_por)VALUES(?,?,?)";
//				pst = con.prepareStatement(cursoInsert);
//				pst.setString(1, obj.getNome());
//				pst.setString(2, obj.getSigla());
//				pst.setInt(3, obj.getCriado_por());
//				
//				int i = pst.executeUpdate();
//				if(i < 0) {
//					msg = "Não foi possivel cadastrar o curso";
//				}
//			}
//			else {
//				msg = "Não foi possivel abrir o banco";
//			}
//		}
//		catch(SQLException se) {
//			msg = "Erro ao tentar cadastrar o curso. Mensagem:"+se.getMessage();
//		}
//		return msg;
//	}
//
//	@Override
//	public Boolean atualizar(Cursos obj) {
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
//	public List<Cursos> listar() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Cursos listarID(Integer ID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
