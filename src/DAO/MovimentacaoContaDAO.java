package DAO;

import model.MovimentacaoConta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoContaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO movimentacao_conta (conta_id, tipo_movimentacao, valor, dt_movimentacao) VALUES (?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM movimentacao_conta";
    private static final String DELETE = "DELETE FROM movimentacao_conta WHERE id = ?";
    private static final String UPDATE = "UPDATE movimentacao_conta SET conta_id = ?, tipo_movimentacao = ?, valor = ?, dt_movimentacao = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM movimentacao_conta WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM movimentacao_conta";

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

    public void insert(MovimentacaoConta movimentacaoConta) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setInt(1, movimentacaoConta.getContaId());
            preparedStatement.setString(2, movimentacaoConta.getTipoMovimentacao());
            preparedStatement.setDouble(3, movimentacaoConta.getValor());
            preparedStatement.setString(4, movimentacaoConta.getDtMovimentacao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovimentacaoConta> select() {
        List<MovimentacaoConta> movimentacaoContas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int contaId = rs.getInt("conta_id");
                String tipoMovimentacao = rs.getString("tipo_movimentacao");
                double valor = rs.getDouble("valor");
                String dtMovimentacao = rs.getString("dt_movimentacao");
                movimentacaoContas.add(new MovimentacaoConta(id, valor, dtMovimentacao, tipoMovimentacao, contaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacaoContas;
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

    public void update(MovimentacaoConta movimentacaoConta) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setInt(1, movimentacaoConta.getContaId());
            preparedStatement.setString(2, movimentacaoConta.getTipoMovimentacao());
            preparedStatement.setDouble(3, movimentacaoConta.getValor());
            preparedStatement.setString(4, movimentacaoConta.getDtMovimentacao());
            preparedStatement.setInt(5, movimentacaoConta.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimentacaoConta select(int id) {
        MovimentacaoConta movimentacaoConta = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int contaId = rs.getInt("conta_id");
                String tipoMovimentacao = rs.getString("tipo_movimentacao");
                double valor = rs.getDouble("valor");
                String dtMovimentacao = rs.getString("dt_movimentacao");
                movimentacaoConta = new MovimentacaoConta(id, valor, dtMovimentacao, tipoMovimentacao, contaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacaoConta;
    }
}