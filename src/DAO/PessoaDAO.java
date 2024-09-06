package DAO;

import model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends ConexaoDB {

    private static final String INSERT_Pessoa_SQL = "INSERT INTO pessoa (nome, cpf) VALUES (?, ?);";
    private static final String SELECT_Pessoa_BY_ID = "SELECT nome, cpf FROM Pessoa WHERE id = ?;";
    private static final String SELECT_ALL_Pessoa = "SELECT * FROM Pessoa;";
    private static final String DELETE_Pessoa_SQL = "DELETE FROM Pessoa WHERE id = ?;";
    private static final String UPDATE_Pessoa_SQL = "UPDATE Pessoa SET nome = ?, cpf = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM Pessoa;";

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

    public void insertPessoa(Pessoa entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_Pessoa_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCpf());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Pessoa selectPessoa(int id) {
        Pessoa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_Pessoa_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");

                entidade = new Pessoa(id, nome, cpf);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Pessoa> selectAllPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_Pessoa)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");

                Pessoa pessoa = new Pessoa(id, nome, cpf);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }

    public boolean deletePessoa(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_Pessoa_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePessoa(Pessoa entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_Pessoa_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCpf());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
