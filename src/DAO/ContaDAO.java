package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conta;

public class ContaDAO extends ConexaoDB {
    private static final String INSERT_CONTA_SQL = "INSERT INTO conta (saldo, limite_negativo, client_id, tipo_conta_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONTA_BY_ID = "SELECT saldo, limite_negativo, client_id, tipo_conta_id FROM Conta WHERE id = ?;";
    private static final String SELECT_ALL_CONTA = "SELECT * FROM Conta;";
    private static final String DELETE_CONTA_SQL = "DELETE FROM Conta WHERE id = ?;";
    private static final String UPDATE_CONTA_SQL = "UPDATE Conta SET saldo = ?, limite_negativo = ?, client_id = ?, tipo_conta_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM Conta;";
    
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

    public void insertConta(Conta entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONTA_SQL)) {
            preparedStatement.setDouble(1, entidade.getSaldo());
            preparedStatement.setDouble(2, entidade.getLimiteNegativo());
            preparedStatement.setInt(3, entidade.getClientId());
            preparedStatement.setInt(4, entidade.getTipoContaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Conta selectConta(int id) {
        Conta conta = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double saldo = rs.getDouble("saldo");
                double limiteNegativo = rs.getDouble("limite_negativo");
                int clientId = rs.getInt("client_id");
                int tipoContaId = rs.getInt("tipo_conta_id");

                conta = new Conta(id, saldo, limiteNegativo, clientId, tipoContaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conta;
    }

    public void deleteConta(int id) {
        try (PreparedStatement preparedStatement = prepararSQL(DELETE_CONTA_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateConta(Conta entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_CONTA_SQL)) {
            preparedStatement.setDouble(1, entidade.getSaldo());
            preparedStatement.setDouble(2, entidade.getLimiteNegativo());
            preparedStatement.setInt(3, entidade.getClientId());
            preparedStatement.setInt(4, entidade.getTipoContaId());
            preparedStatement.setInt(5, entidade.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Conta> selectAllConta() {
        List<Conta> contas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double saldo = rs.getDouble("saldo");
                double limiteNegativo = rs.getDouble("limite_negativo");
                int clientId = rs.getInt("client_id");
                int tipoContaId = rs.getInt("tipo_conta_id");

                Conta conta = new Conta(id, saldo, limiteNegativo, clientId, tipoContaId);
                contas.add(conta);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contas;
    }
}
