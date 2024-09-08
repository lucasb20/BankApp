package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import model.Pagamento;

import java.util.ArrayList;

public class PagamentoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO pagamento (valor_total, dt_pagamento, fatura_cartao_id, valor_parcial, boleto_customizado_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM pagamento";
    private static final String DELETE = "DELETE FROM pagamento WHERE id = ?";
    private static final String UPDATE = "UPDATE pagamento SET valor_total = ?, dt_pagamento = ?, fatura_cartao_id = ?, valor_parcial = ?, boleto_customizado_id = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM pagamento WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM pagamento";

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

    public void insert(Pagamento pagamento) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setDouble(1, pagamento.getValorTotal());
            preparedStatement.setString(2, pagamento.getDtPagamento());
            preparedStatement.setInt(3, pagamento.getFaturaCartaoId());
            preparedStatement.setDouble(4, pagamento.getValorParcial());
            preparedStatement.setInt(5, pagamento.getBoletoCustomizadoId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pagamento> select() {
        List<Pagamento> pagamentos = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double valorTotal = rs.getDouble("valor_total");
                String dtPagamento = rs.getString("dt_pagamento");
                int faturaCartaoId = rs.getInt("fatura_cartao_id");
                double valorParcial = rs.getDouble("valor_parcial");
                int boletoCustomizadoId = rs.getInt("boleto_customizado_id");

                Pagamento pagamento = new Pagamento(id, valorTotal, dtPagamento, faturaCartaoId, valorParcial, boletoCustomizadoId);
                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pagamentos;
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

    public void update(Pagamento pagamento) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setDouble(1, pagamento.getValorTotal());
            preparedStatement.setString(2, pagamento.getDtPagamento());
            preparedStatement.setInt(3, pagamento.getFaturaCartaoId());
            preparedStatement.setDouble(4, pagamento.getValorParcial());
            preparedStatement.setInt(5, pagamento.getBoletoCustomizadoId());
            preparedStatement.setInt(6, pagamento.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Pagamento select(int id) {
        Pagamento pagamento = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double valorTotal = rs.getDouble("valor_total");
                String dtPagamento = rs.getString("dt_pagamento");
                int faturaCartaoId = rs.getInt("fatura_cartao_id");
                double valorParcial = rs.getDouble("valor_parcial");
                int boletoCustomizadoId = rs.getInt("boleto_customizado_id");

                pagamento = new Pagamento(id, valorTotal, dtPagamento, faturaCartaoId, valorParcial, boletoCustomizadoId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pagamento;
    }
}