package DAO;

import model.FaturaCartao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaturaCartaoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO fatura_cartao (mes_referencia, ano_referencia, valor, cartao_credito_id, dt_pagamento) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM fatura_cartao";
    private static final String DELETE = "DELETE FROM fatura_cartao WHERE id = ?";
    private static final String UPDATE = "UPDATE fatura_cartao SET mes_referencia = ?, ano_referencia = ?, valor = ?, cartao_credito_id = ?, dt_pagamento = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM fatura_cartao WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM fatura_cartao";

    public int count() {
        int count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insert(FaturaCartao faturaCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, faturaCartao.getMesReferencia());
            preparedStatement.setString(2, faturaCartao.getAnoReferencia());
            preparedStatement.setDouble(3, faturaCartao.getValor());
            preparedStatement.setInt(4, faturaCartao.getCartaoCreditoId());
            preparedStatement.setString(5, faturaCartao.getDtPagamento());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FaturaCartao> select() {
        List<FaturaCartao> faturaCartoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mesReferencia = rs.getString("mes_referencia");
                String anoReferencia = rs.getString("ano_referencia");
                double valor = rs.getDouble("valor");
                int cartaoCreditoId = rs.getInt("cartao_credito_id");
                String dtPagamento = rs.getString("dt_pagamento");

                faturaCartoes.add(new FaturaCartao(id, mesReferencia, anoReferencia, valor, cartaoCreditoId, dtPagamento));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return faturaCartoes;
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = prepararSQL(DELETE)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(FaturaCartao faturaCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, faturaCartao.getMesReferencia());
            preparedStatement.setString(2, faturaCartao.getAnoReferencia());
            preparedStatement.setDouble(3, faturaCartao.getValor());
            preparedStatement.setInt(4, faturaCartao.getCartaoCreditoId());
            preparedStatement.setString(5, faturaCartao.getDtPagamento());
            preparedStatement.setInt(6, faturaCartao.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public FaturaCartao select(int id) {
        FaturaCartao faturaCartao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String mesReferencia = rs.getString("mes_referencia");
                String anoReferencia = rs.getString("ano_referencia");
                double valor = rs.getDouble("valor");
                int cartaoCreditoId = rs.getInt("cartao_credito_id");
                String dtPagamento = rs.getString("dt_pagamento");

                faturaCartao = new FaturaCartao(id, mesReferencia, anoReferencia, valor, cartaoCreditoId, dtPagamento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return faturaCartao;
    }
}