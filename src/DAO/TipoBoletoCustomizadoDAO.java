package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import model.TipoBoletoCustomizado;

import java.util.ArrayList;

public class TipoBoletoCustomizadoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO tipo_boleto_customizado (descricao) VALUES (?)";
    private static final String SELECT = "SELECT * FROM tipo_boleto_customizado";
    private static final String DELETE = "DELETE FROM tipo_boleto_customizado WHERE id = ?";
    private static final String UPDATE = "UPDATE tipo_boleto_customizado SET descricao = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM tipo_boleto_customizado WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM tipo_boleto_customizado";
    
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

    public void insert(TipoBoletoCustomizado tipoBoletoCustomizado) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, tipoBoletoCustomizado.getDescricao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TipoBoletoCustomizado> select() {
        List<TipoBoletoCustomizado> tipoBoletosCustomizados = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");

                TipoBoletoCustomizado tipoBoletoCustomizado = new TipoBoletoCustomizado(id, descricao);
                tipoBoletosCustomizados.add(tipoBoletoCustomizado);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tipoBoletosCustomizados;
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

    public void update(TipoBoletoCustomizado tipoBoletoCustomizado) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, tipoBoletoCustomizado.getDescricao());
            preparedStatement.setInt(2, tipoBoletoCustomizado.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoBoletoCustomizado select(int id) {
        TipoBoletoCustomizado tipoBoletoCustomizado = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");

                tipoBoletoCustomizado = new TipoBoletoCustomizado(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tipoBoletoCustomizado;
    }
}