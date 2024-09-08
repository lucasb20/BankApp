package DAO;

import model.CartaoCredito;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartaoCreditoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO cartao_credito (dt_fechamento, limite_credito, categoria_cartao_id, conta_id) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM cartao_credito WHERE id = ?";
    private static final String UPDATE = "UPDATE cartao_credito SET dt_fechamento = ?, limite_credito = ?, categoria_cartao_id = ?, conta_id = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM cartao_credito WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM cartao_credito";
    private static final String SELECT = "SELECT * FROM cartao_credito";

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

    public void insert(CartaoCredito cartaoCredito) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, cartaoCredito.getDtFechamento());
            preparedStatement.setDouble(2, cartaoCredito.getLimiteCredito());
            preparedStatement.setInt(3, cartaoCredito.getCategoriaCartaoId());
            preparedStatement.setInt(4, cartaoCredito.getContaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CartaoCredito> select() {
        List<CartaoCredito> cartaoCreditos = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String dt_fechamento = rs.getString("dt_fechamento");
                double limite_credito = rs.getDouble("limite_credito");
                int categoria_cartao_id = rs.getInt("categoria_cartao_id");
                int conta_id = rs.getInt("conta_id");

                cartaoCreditos.add(new CartaoCredito(id, dt_fechamento, limite_credito, categoria_cartao_id, conta_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cartaoCreditos;
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

    public void update(CartaoCredito cartaoCredito) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, cartaoCredito.getDtFechamento());
            preparedStatement.setDouble(2, cartaoCredito.getLimiteCredito());
            preparedStatement.setInt(3, cartaoCredito.getCategoriaCartaoId());
            preparedStatement.setInt(4, cartaoCredito.getContaId());
            preparedStatement.setInt(5, cartaoCredito.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CartaoCredito select(int id) {
        CartaoCredito cartaoCredito = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String dt_fechamento = rs.getString("dt_fechamento");
                double limite_credito = rs.getDouble("limite_credito");
                int categoria_cartao_id = rs.getInt("categoria_cartao_id");
                int conta_id = rs.getInt("conta_id");

                cartaoCredito = new CartaoCredito(id, dt_fechamento, limite_credito, categoria_cartao_id, conta_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cartaoCredito;
    }
}