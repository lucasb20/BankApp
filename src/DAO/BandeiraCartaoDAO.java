package DAO;

import model.BandeiraCartao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BandeiraCartaoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO bandeira_cartao (descricao) VALUES (?)";
    private static final String SELECT = "SELECT * FROM bandeira_cartao";
    private static final String DELETE = "DELETE FROM bandeira_cartao WHERE id = ?";
    private static final String UPDATE = "UPDATE bandeira_cartao SET descricao = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM bandeira_cartao WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM bandeira_cartao";

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

    public void insert(BandeiraCartao bandeiraCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, bandeiraCartao.getDescricao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BandeiraCartao> select() {
        List<BandeiraCartao> bandeiraCartoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");

                bandeiraCartoes.add(new BandeiraCartao(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bandeiraCartoes;
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

    public void update(BandeiraCartao bandeiraCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, bandeiraCartao.getDescricao());
            preparedStatement.setInt(2, bandeiraCartao.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public BandeiraCartao select(int id) {
        BandeiraCartao bandeiraCartao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");

                bandeiraCartao = new BandeiraCartao(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bandeiraCartao;
    }
}
