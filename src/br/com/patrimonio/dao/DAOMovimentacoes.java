package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.patrimonio.pojo.Movimentacoes;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Movimentacoes listarID(Integer ID) {
        // TODO Auto-generated method stub
        return null;
    }
}
