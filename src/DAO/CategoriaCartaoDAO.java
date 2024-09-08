package DAO;

import model.CategoriaCartao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaCartaoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO categoria_cartao (descricao) VALUES (?)";
    private static final String SELECT = "SELECT * FROM categoria_cartao";
    private static final String DELETE = "DELETE FROM categoria_cartao WHERE id = ?";
    private static final String UPDATE = "UPDATE categoria_cartao SET descricao = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM categoria_cartao WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM categoria_cartao";

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

    public void insert(CategoriaCartao categoriaCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, categoriaCartao.getDescricao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CategoriaCartao> select() {
        List<CategoriaCartao> categoriaCartoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");

                categoriaCartoes.add(new CategoriaCartao(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categoriaCartoes;
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

    public void update(CategoriaCartao categoriaCartao) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, categoriaCartao.getDescricao());
            preparedStatement.setInt(2, categoriaCartao.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CategoriaCartao select(int id) {
        CategoriaCartao categoriaCartao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");

                categoriaCartao = new CategoriaCartao(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categoriaCartao;
    }
}