//package br.com.patrimonio.dao;
//
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.patrimonio.pojo.Patrimonio;
//import br.com.patrimonio.pojo.Status;
//
//public class DAOPatrimonios extends Conexao implements CRUD<Patrimonio> {
//
//    @Override
//    public String cadastrar(Patrimonio obj) {
//        String msg = "Cadastro realizado";
//
//        try {
//            if (abrir()) {
//
//                String patrimonioInsert =
//                        "INSERT INTO patrimonios "
//                        + "(numero_tombamento, nome, descricao, curso_id, local_id, "
//                        + "categoria_id, status, valor_aquisicao, data_aquisicao, "
//                        + "criado_por, atualizado_por) "
//                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//                pst = con.prepareStatement(patrimonioInsert);
//
//                pst.setString(1, obj.getNumero_tombamento());
//                pst.setString(2, obj.getNome());
//                pst.setString(3, obj.getDescricao());
//
//                pst.setInt(4, obj.getCurso_id());
//                pst.setInt(5, obj.getLocal_id());
//                pst.setInt(6, obj.getCategoria_id());
//
//                if (obj.getStatus() != null) {
//                    pst.setString(7, obj.getStatus().name());
//                } else {
//                    pst.setString(7, Status.Disponivel.name());
//                }
//
//                pst.setDouble(8, obj.getValor_aquisicao());
//                pst.setDate(9, obj.getData_aquisicao());
//
//                pst.setInt(10, obj.getCriado_por());
//
//                // Pode ser NULL
//                pst.setObject(11, obj.getAtualizado_por());
//
//                int i = pst.executeUpdate();
//
//                if (i == 0) {
//                    msg = "Não foi possível cadastrar o patrimônio";
//                }
//
//            } else {
//                msg = "Não foi possível abrir o banco";
//            }
//
//        } catch (SQLException se) {
//            msg = "Erro ao tentar cadastrar o patrimônio. Mensagem: "
//                    + se.getMessage();
//        }
//
//        return msg;
//    }
//
//    @Override
//    public Boolean atualizar(Patrimonio obj) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public String deletar(Integer id) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public List<Patrimonio> listar() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public Patrimonio listarID(Integer ID) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//}
