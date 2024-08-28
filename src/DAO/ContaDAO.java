package DAO;

import model.Conta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO extends ConexaoDB {

    private static final String INSERT_CONTA_SQL = "INSERT INTO conta (nome, cpf, renda_mensal, saldo, divida, tipo_conta) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CONTA_BY_ID = "SELECT id, nome, cpf, renda_mensal, saldo, divida, tipo_conta FROM conta WHERE id = ?;";
    private static final String SELECT_ALL_CONTA = "SELECT * FROM conta;";
    private static final String DELETE_CONTA_SQL = "DELETE FROM conta WHERE id = ?;";
    private static final String UPDATE_CONTA_SQL = "UPDATE conta SET nome = ?, cpf = ?, renda_mensal = ?, saldo = ?, divida = ?, tipo_conta = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM conta;";

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
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCpf());
            preparedStatement.setDouble(3, entidade.getRendaMensal());
            preparedStatement.setDouble(4, entidade.getSaldo());
            preparedStatement.setDouble(5, entidade.getDivida());
            preparedStatement.setString(6, entidade.getTipoConta());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Conta selectConta(int id) {
        Conta entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                double rendaMensal = rs.getDouble("renda_mensal");
                double saldo = rs.getDouble("saldo");
                double divida = rs.getDouble("divida");
                String tipoConta = rs.getString("tipo_conta");

                entidade = new Conta(id, nome, cpf, rendaMensal, saldo, divida, tipoConta);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Conta> selectAllContas() {
        List<Conta> contas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                double rendaMensal = rs.getDouble("renda_mensal");
                double saldo = rs.getDouble("saldo");
                double divida = rs.getDouble("divida");
                String tipoConta = rs.getString("tipo_conta");

                Conta conta = new Conta(id, nome, cpf, rendaMensal, saldo, divida, tipoConta);
                contas.add(conta);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contas;
    }

    public boolean deleteConta(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CONTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConta(Conta entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CONTA_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCpf());
            statement.setDouble(3, entidade.getRendaMensal());
            statement.setDouble(4, entidade.getSaldo());
            statement.setDouble(5, entidade.getDivida());
            statement.setString(6, entidade.getTipoConta());
            statement.setInt(7, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
