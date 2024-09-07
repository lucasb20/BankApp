package DAO;

import model.TipoConta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoContaDAO extends ConexaoDB {
    
    private static final String INSERT_TIPO_CONTA_SQL = "INSERT INTO tipo_conta (descricao) VALUES (?);";
    private static final String SELECT_TIPO_CONTA_BY_ID = "SELECT descricao FROM tipo_conta WHERE id = ?;";
    private static final String SELECT_ALL_TIPO_CONTA = "SELECT * FROM tipo_conta;";
    private static final String DELETE_TIPO_CONTA_SQL = "DELETE FROM tipo_conta WHERE id = ?;";
    private static final String UPDATE_TIPO_CONTA_SQL = "UPDATE tipo_conta SET descricao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tipo_conta;";

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

    public void insertTipoConta(TipoConta entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TIPO_CONTA_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoConta selectTipoConta(int id) {
        TipoConta entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TIPO_CONTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");

                entidade = new TipoConta(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<TipoConta> selectAllTipoContas() {
        List<TipoConta> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TIPO_CONTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");

                entidades.add(new TipoConta(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public void updateTipoConta(TipoConta entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_TIPO_CONTA_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTipoConta(int id) {
        try (PreparedStatement preparedStatement = prepararSQL(DELETE_TIPO_CONTA_SQL)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
