package DAO;

import model.MovimentacaoCartao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoCartaoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO movimentacao_cartao (cartao_transacao_id, tipo_movimentacao, valor, dt_movimentacao) VALUES (?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM movimentacao_cartao";
    private static final String DELETE = "DELETE FROM movimentacao_cartao WHERE id = ?";
    private static final String UPDATE = "UPDATE movimentacao_cartao SET cartao_transacao_id = ?, tipo_movimentacao = ?, valor = ?, dt_movimentacao = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM movimentacao_cartao WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM movimentacao_cartao";

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

    public void insert(MovimentacaoCartao movimentacaoCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setInt(1, movimentacaoCartao.getCartaoTransacaoId());
            preparedStatement.setString(2, movimentacaoCartao.getTipoMovimentacao());
            preparedStatement.setDouble(3, movimentacaoCartao.getValor());
            preparedStatement.setString(4, movimentacaoCartao.getDtMovimentacao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovimentacaoCartao> select() {
        List<MovimentacaoCartao> movimentacaoCartoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int cartaoTransacaoId = rs.getInt("cartao_transacao_id");
                String tipoMovimentacao = rs.getString("tipo_movimentacao");
                double valor = rs.getDouble("valor");
                String dtMovimentacao = rs.getString("dt_movimentacao");

                MovimentacaoCartao movimentacaoCartao = new MovimentacaoCartao(id, cartaoTransacaoId, tipoMovimentacao, valor, dtMovimentacao);
                movimentacaoCartoes.add(movimentacaoCartao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacaoCartoes;
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

    public void update(MovimentacaoCartao movimentacaoCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setInt(1, movimentacaoCartao.getCartaoTransacaoId());
            preparedStatement.setString(2, movimentacaoCartao.getTipoMovimentacao());
            preparedStatement.setDouble(3, movimentacaoCartao.getValor());
            preparedStatement.setString(4, movimentacaoCartao.getDtMovimentacao());
            preparedStatement.setInt(5, movimentacaoCartao.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimentacaoCartao select(int id) {
        MovimentacaoCartao movimentacaoCartao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int cartaoTransacaoId = rs.getInt("cartao_transacao_id");
                String tipoMovimentacao = rs.getString("tipo_movimentacao");
                double valor = rs.getDouble("valor");
                String dtMovimentacao = rs.getString("dt_movimentacao");

                movimentacaoCartao = new MovimentacaoCartao(id, cartaoTransacaoId, tipoMovimentacao, valor, dtMovimentacao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacaoCartao;
    }
}