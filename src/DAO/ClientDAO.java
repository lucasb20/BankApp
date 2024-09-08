package DAO;

import model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends ConexaoDB {

    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (fator_risco, renda_mensal, pessoa_id) VALUES (?, ?, ?);";
    private static final String SELECT_CLIENT_BY_ID = "SELECT fator_risco, renda_mensal, pessoa_id FROM client WHERE id = ?;";
    private static final String SELECT_ALL_CLIENT = "SELECT * FROM client;";
    private static final String DELETE_CLIENT_SQL = "DELETE FROM client WHERE id = ?;";
    private static final String UPDATE_CLIENT_SQL = "UPDATE client SET fator_risco = ?, renda_mensal = ?, pessoa_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM client;";

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

    public void insertClient(Client entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CLIENT_SQL)) {
            preparedStatement.setString(1, entidade.getFatorRisco());
            preparedStatement.setDouble(2, entidade.getRendaMensal());
            preparedStatement.setInt(3, entidade.getPessoaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Client selectClient(int id) {
        Client entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CLIENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String fator_risco = rs.getString("fator_risco");
                double renda_mensal = rs.getDouble("renda_mensal");
                int pessoa_id = rs.getInt("pessoa_id");

                entidade = new Client(id, fator_risco, renda_mensal, pessoa_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Client> selectAllClients() {
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CLIENT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fator_risco = rs.getString("fator_risco");
                double renda_mensal = rs.getDouble("renda_mensal");
                int pessoa_id = rs.getInt("pessoa_id");

                Client client = new Client(id, fator_risco, renda_mensal, pessoa_id);
                clients.add(client);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public boolean deleteClient(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CLIENT_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateClient(Client entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CLIENT_SQL)) {
            statement.setString(1, entidade.getFatorRisco());
            statement.setDouble(2, entidade.getRendaMensal());
            statement.setInt(3, entidade.getPessoaId());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}