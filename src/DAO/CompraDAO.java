package DAO;

import model.Compra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO compra (quantidade_parcelas, valor, cartao_credito_id, corretor_id, taxa_parcelamento, credor, dt_compra) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM compra WHERE id = ?";
    private static final String UPDATE = "UPDATE compra SET quantidade_parcelas = ?, valor = ?, cartao_credito_id = ?, corretor_id = ?, taxa_parcelamento = ?, credor = ?, dt_compra = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM compra WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM compra";
    private static final String SELECT = "SELECT * FROM compra";

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

    public void insert(Compra compra) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setInt(1, compra.getQuantidadeParcela());
            preparedStatement.setDouble(2, compra.getValor());
            preparedStatement.setInt(3, compra.getCartaoTransacaoId());
            preparedStatement.setInt(4, compra.getCorretorId());
            preparedStatement.setDouble(5, compra.getTaxaParcelamento());
            preparedStatement.setString(6, compra.getCredor());
            preparedStatement.setString(7, compra.getDtCompra());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Compra> select() {
        List<Compra> compras = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int quantidade_parcelas = rs.getInt("quantidade_parcelas");
                double valor = rs.getDouble("valor");
                int cartao_credito_id = rs.getInt("cartao_credito_id");
                int corretor_id = rs.getInt("corretor_id");
                double taxa_parcelamento = rs.getDouble("taxa_parcelamento");
                String credor = rs.getString("credor");
                String dt_compra = rs.getString("dt_compra");

                compras.add(new Compra(id, quantidade_parcelas, valor, cartao_credito_id, corretor_id, taxa_parcelamento, credor, dt_compra));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return compras;
    }

    public Compra selectId(int id) {
        Compra compra = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int quantidade_parcelas = rs.getInt("quantidade_parcelas");
                double valor = rs.getDouble("valor");
                int cartao_credito_id = rs.getInt("cartao_credito_id");
                int corretor_id = rs.getInt("corretor_id");
                double taxa_parcelamento = rs.getDouble("taxa_parcelamento");
                String credor = rs.getString("credor");
                String dt_compra = rs.getString("dt_compra");

                compra = new Compra(id, quantidade_parcelas, valor, cartao_credito_id, corretor_id, taxa_parcelamento, credor, dt_compra);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return compra;
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

    public void update(Compra compra) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setInt(1, compra.getQuantidadeParcela());
            preparedStatement.setDouble(2, compra.getValor());
            preparedStatement.setInt(3, compra.getCartaoTransacaoId());
            preparedStatement.setInt(4, compra.getCorretorId());
            preparedStatement.setDouble(5, compra.getTaxaParcelamento());
            preparedStatement.setString(6, compra.getCredor());
            preparedStatement.setString(7, compra.getDtCompra());
            preparedStatement.setInt(8, compra.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}