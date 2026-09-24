package br.com.patrimonio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Patrimonio;
import br.com.patrimonio.pojo.Status;

public class DAOPatrimonios extends Conexao implements CRUD<Patrimonio> {

    @Override
    public String cadastrar(Patrimonio obj) {

        String msg = "Cadastro realizado";

        try {

            if (abrir()) {

                String patrimonioInsert =
                        "INSERT INTO patrimonios "
                        + "(numero_tombamento, nome, descricao, curso_id, local_id, "
                        + "categoria_id, status, valor_aquisicao, data_aquisicao, "
                        + "criado_por, atualizado_por) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                pst = con.prepareStatement(patrimonioInsert);

                pst.setString(
                        1,
                        obj.getNumero_tombamento()
                );

                pst.setString(
                        2,
                        obj.getNome()
                );

                pst.setString(
                        3,
                        obj.getDescricao()
                );

                pst.setInt(
                        4,
                        obj.getCurso_id()
                );

                pst.setInt(
                        5,
                        obj.getLocal_id()
                );

                pst.setInt(
                        6,
                        obj.getCategoria_id()
                );

                if (obj.getStatus() != null) {

                    pst.setString(
                            7,
                            obj.getStatus().name()
                    );

                } else {

                    pst.setString(
                            7,
                            Status.Disponível.name()
                    );
                }

                pst.setDouble(
                        8,
                        obj.getValor_aquisicao()
                );

                pst.setDate(
                        9,
                        obj.getData_aquisicao()
                );

                pst.setInt(
                        10,
                        obj.getCriado_por()
                );

                // Pode ser NULL
                pst.setObject(
                        11,
                        obj.getAtualizado_por()
                );

                int i =
                        pst.executeUpdate();

                if (i == 0) {

                    msg =
                            "Não foi possível cadastrar o patrimônio";
                }

            } else {

                msg =
                        "Não foi possível abrir o banco";
            }

        } catch (SQLException se) {

            msg =
                    "Erro ao tentar cadastrar o patrimônio. Mensagem: "
                    + se.getMessage();
        }

        return msg;
    }

    // =========================================================
    // ATUALIZAR
    // =========================================================

    @Override
    public Boolean atualizar(Patrimonio obj) {

        // Ainda não implementado
        return null;
    }

    // =========================================================
    // DELETAR
    // =========================================================

    @Override
    public String deletar(Integer id) {

        // Ainda não implementado
        return null;
    }

    // =========================================================
    // LISTAR PATRIMÔNIOS
    // =========================================================

    @Override
    public List<Patrimonio> listar() {

        List<Patrimonio> lista =
                new ArrayList<>();

        try {

            if (abrir()) {

                String sql =
                        "SELECT id, numero_tombamento, nome, descricao, "
                        + "curso_id, local_id, categoria_id, status, "
                        + "valor_aquisicao, data_aquisicao, criado_por, "
                        + "atualizado_por, criado_em, atualizado_em "
                        + "FROM patrimonios";

                pst =
                        con.prepareStatement(sql);

                ResultSet rs =
                        pst.executeQuery();

                while (rs.next()) {

                    Patrimonio patrimonio =
                            new Patrimonio();

                    // -----------------------------------------
                    // ID
                    // -----------------------------------------

                    patrimonio.setId(
                            rs.getInt("id")
                    );

                    // -----------------------------------------
                    // NÚMERO DE TOMBAMENTO
                    // -----------------------------------------

                    patrimonio.setNumero_tombamento(
                            rs.getString(
                                    "numero_tombamento"
                            )
                    );

                    // -----------------------------------------
                    // NOME
                    // -----------------------------------------

                    patrimonio.setNome(
                            rs.getString("nome")
                    );

                    // -----------------------------------------
                    // DESCRIÇÃO
                    // -----------------------------------------

                    patrimonio.setDescricao(
                            rs.getString("descricao")
                    );

                    // -----------------------------------------
                    // CURSO
                    // -----------------------------------------

                    patrimonio.setCurso_id(
                            rs.getInt("curso_id")
                    );

                    // -----------------------------------------
                    // LOCAL
                    // -----------------------------------------

                    patrimonio.setLocal_id(
                            rs.getInt("local_id")
                    );

                    // -----------------------------------------
                    // CATEGORIA
                    // -----------------------------------------

                    patrimonio.setCategoria_id(
                            rs.getInt("categoria_id")
                    );

                    // -----------------------------------------
                    // STATUS
                    // -----------------------------------------

                    String status =
                            rs.getString("status");

                    if (status != null) {

                        patrimonio.setStatus(
                                Status.valueOf(status)
                        );
                    }

                    // -----------------------------------------
                    // VALOR
                    // -----------------------------------------

                    patrimonio.setValor_aquisicao(
                            rs.getDouble(
                                    "valor_aquisicao"
                            )
                    );

                    // -----------------------------------------
                    // DATA DE AQUISIÇÃO
                    // -----------------------------------------

                    patrimonio.setData_aquisicao(
                            rs.getDate(
                                    "data_aquisicao"
                            )
                    );

                    // -----------------------------------------
                    // CRIADO POR
                    // -----------------------------------------

                    patrimonio.setCriado_por(
                            rs.getInt("criado_por")
                    );

                    // -----------------------------------------
                    // ATUALIZADO POR
                    // -----------------------------------------

                    patrimonio.setAtualizado_por(
                            rs.getInt("atualizado_por")
                    );

                    // -----------------------------------------
                    // CRIADO EM
                    // -----------------------------------------

                    patrimonio.setCriado_em(
                            rs.getTimestamp(
                                    "criado_em"
                            )
                    );

                    // -----------------------------------------
                    // ATUALIZADO EM
                    // -----------------------------------------

                    patrimonio.setAtualizado_em(
                            rs.getTimestamp(
                                    "atualizado_em"
                            )
                    );

                    // -----------------------------------------
                    // ADICIONA NA LISTA
                    // -----------------------------------------

                    lista.add(
                            patrimonio
                    );
                }

                rs.close();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        // IMPORTANTE:
        // Nunca retorna null.
        // Se não houver registros, retorna uma lista vazia.

        return lista;
    }

    // =========================================================
    // LISTAR POR ID
    // =========================================================

    @Override
    public Patrimonio listarID(Integer ID) {

        // Ainda não implementado
        return null;
    }
}
