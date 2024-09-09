package DAO;

import model.CartaoTransacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartaoTransacaoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO cartao_transacao (numero_cartao, cvc, cartao_credito_id, tipo_cartao, nome_cartao, tipo_transacao, is_internacional, bandeira_cartao_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM cartao_transacao WHERE id = ?";
    private static final String UPDATE = "UPDATE cartao_transacao SET numero_cartao = ?, cvc = ?, cartao_credito_id = ?, tipo_cartao = ?, nome_cartao = ?, tipo_transacao = ?, is_internacional = ?, bandeira_cartao_id = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM cartao_transacao WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM cartao_transacao";
    private static final String SELECT = "SELECT * FROM cartao_transacao";

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

    public void insert(CartaoTransacao cartaoTransacao) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, cartaoTransacao.getNumeroCartao());
            preparedStatement.setString(2, cartaoTransacao.getCvc());
            preparedStatement.setInt(3, cartaoTransacao.getCartaoCreditoId());
            preparedStatement.setString(4, cartaoTransacao.getTipoCartao());
            preparedStatement.setString(5, cartaoTransacao.getNomeCartao());
            preparedStatement.setString(6, cartaoTransacao.getTipoTransacao());
            preparedStatement.setInt(7, cartaoTransacao.getIsInternacional());
            preparedStatement.setInt(8, cartaoTransacao.getBandeiraCartaoId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CartaoTransacao> select() {
        List<CartaoTransacao> cartaoTransacaos = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String numero_cartao = rs.getString("numero_cartao");
                String cvc = rs.getString("cvc");
                int cartao_id = rs.getInt("cartao_id");
                String tipo_cartao = rs.getString("tipo_cartao");
                String nome_cartao = rs.getString("nome_cartao");
                String tipo_transacao = rs.getString("tipo_transacao");
                int is_internacional = rs.getInt("is_internacional");
                int bandeira_cartao_id = rs.getInt("bandeira_cartao_id");

                cartaoTransacaos.add(new CartaoTransacao(id, numero_cartao, cvc, cartao_id, tipo_cartao, nome_cartao, tipo_transacao, is_internacional, bandeira_cartao_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cartaoTransacaos;
    }

    public CartaoTransacao select(int id) {
        CartaoTransacao cartaoTransacao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String numero_cartao = rs.getString("numero_cartao");
                String cvc = rs.getString("cvc");
                int cartao_id = rs.getInt("cartao_id");
                String tipo_cartao = rs.getString("tipo_cartao");
                String nome_cartao = rs.getString("nome_cartao");
                String tipo_transacao = rs.getString("tipo_transacao");
                int is_internacional = rs.getInt("is_internacional");
                int bandeira_cartao_id = rs.getInt("bandeira_cartao_id");

                cartaoTransacao = new CartaoTransacao(id, numero_cartao, cvc, cartao_id, tipo_cartao, nome_cartao, tipo_transacao, is_internacional, bandeira_cartao_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cartaoTransacao;
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

    public void update(CartaoTransacao cartaoTransacao) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setString(1, cartaoTransacao.getNumeroCartao());
            preparedStatement.setString(2, cartaoTransacao.getCvc());
            preparedStatement.setInt(3, cartaoTransacao.getCartaoCreditoId());
            preparedStatement.setString(4, cartaoTransacao.getTipoCartao());
            preparedStatement.setString(5, cartaoTransacao.getNomeCartao());
            preparedStatement.setString(6, cartaoTransacao.getTipoTransacao());
            preparedStatement.setInt(7, cartaoTransacao.getIsInternacional());
            preparedStatement.setInt(8, cartaoTransacao.getBandeiraCartaoId());
            preparedStatement.setInt(9, cartaoTransacao.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}