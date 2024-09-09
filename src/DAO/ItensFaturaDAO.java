package DAO;

import model.ItensFatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItensFaturaDAO extends ConexaoDB {
    
    private static final String INSERT = "INSERT INTO itens_fatura (descricao, fatura_cartao_id) VALUES (?, ?)";
    private static final String SELECT = "SELECT * FROM itens_fatura";
    private static final String DELETE = "DELETE FROM itens_fatura WHERE id = ?";
    private static final String UPDATE = "UPDATE itens_fatura SET descricao = ?, fatura_cartao_id = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM itens_fatura WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM itens_fatura";

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

    public void insert(ItensFatura itensFatura) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, itensFatura.getDescricao());
            preparedStatement.setInt(2, itensFatura.getFaturaCartaoId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItensFatura> select() {
        List<ItensFatura> itensFaturas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int faturaCartaoId = rs.getInt("fatura_cartao_id");
                itensFaturas.add(new ItensFatura(id, descricao, faturaCartaoId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itensFaturas;
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

    public void update(ItensFatura itensFatura) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, itensFatura.getDescricao());
            preparedStatement.setInt(2, itensFatura.getFaturaCartaoId());
            preparedStatement.setInt(3, itensFatura.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ItensFatura select(int id) {
        ItensFatura itensFatura = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");
                int faturaCartaoId = rs.getInt("fatura_cartao_id");

                itensFatura = new ItensFatura(id, descricao, faturaCartaoId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itensFatura;
    }
}