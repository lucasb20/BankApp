package DAO;

import model.Conta;

public class ContaDAO extends ConexaoDB {

    private static final String INSERT_CONTA_SQL = "INSERT INTO conta (nome, cpf, renda_mensal, saldo, tipo_conta_id) VALUES (?, ?, ?, ?, ?);";
    // join para tipo_conta?
    private static final String SELECT_CONTA_BY_ID = "SELECT id, nome, cpf, renda_mensal, saldo FROM conta WHERE id = ?;";
    private static final String SELECT_ALL_CONTA = "SELECT * FROM conta;";
    private static final String DELETE_CONTA_SQL = "DELETE FROM conta WHERE id = ?;";
    // alterar renda_mensal
    private static final String UPDATE_CONTA_SQL = "UPDATE conta SET saldo = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM conta;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    // Terminar essas funções
    public void insertConta(Conta entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONTA_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
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

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                entidade = new Marca(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Conta> selectAllContas() {
        List<Conta> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                entidades.add(new Marca(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
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
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
