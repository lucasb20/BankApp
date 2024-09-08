package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import model.MovimentacaoReserva;

import java.util.ArrayList;

public class MovimentacaoReservaDAO extends ConexaoDB {
    private static final String INSERT_MOVIMENTACAO_RESERVA = "INSERT INTO movimentacao_reserva (valor, tipo_movimentacao, dt_movimentacao, reserva_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_MOVIMENTACAO_RESERVA = "SELECT * FROM movimentacao_reserva WHERE reserva_id = ?";
    private static final String UPDATE_MOVIMENTACAO_RESERVA = "UPDATE movimentacao_reserva SET valor = ?, tipo_movimentacao = ?, dt_movimentacao = ? WHERE reserva_id = ?";
    private static final String SELECT_MOVIMENTACAO_RESERVA_BY_ID = "SELECT * FROM movimentacao_reserva WHERE id = ?";
    private static final String DELETE_MOVIMENTACAO_RESERVA = "DELETE FROM movimentacao_reserva WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM movimentacao_reserva";

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

    public void insertMovimentacaoReserva(double valor, String tipo_movimentacao, String dt_movimentacao, int reserva_id) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MOVIMENTACAO_RESERVA)) {
            preparedStatement.setDouble(1, valor);
            preparedStatement.setString(2, tipo_movimentacao);
            preparedStatement.setString(3, dt_movimentacao);
            preparedStatement.setInt(4, reserva_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMovimentacaoReserva(double valor, String tipo_movimentacao, String dt_movimentacao, int reserva_id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_MOVIMENTACAO_RESERVA)) {
            preparedStatement.setDouble(1, valor);
            preparedStatement.setString(2, tipo_movimentacao);
            preparedStatement.setString(3, dt_movimentacao);
            preparedStatement.setInt(4, reserva_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMovimentacaoReserva(int id) {
        try (PreparedStatement preparedStatement = prepararSQL(DELETE_MOVIMENTACAO_RESERVA)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovimentacaoReserva> selectAllMovimentacaoReserva(int reserva_id) {
        List<MovimentacaoReserva> movimentacoes = new ArrayList<MovimentacaoReserva>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MOVIMENTACAO_RESERVA)) {
            preparedStatement.setInt(1, reserva_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double valor = rs.getDouble("valor");
                String tipo_movimentacao = rs.getString("tipo_movimentacao");
                String dt_movimentacao = rs.getString("dt_movimentacao");

                movimentacoes.add(new MovimentacaoReserva(id, valor, tipo_movimentacao, dt_movimentacao, reserva_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacoes;
    }

    public MovimentacaoReserva selectMovimentacaoReserva(int id) {
        MovimentacaoReserva movimentacao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MOVIMENTACAO_RESERVA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double valor = rs.getDouble("valor");
                String tipo_movimentacao = rs.getString("tipo_movimentacao");
                String dt_movimentacao = rs.getString("dt_movimentacao");
                int reserva_id = rs.getInt("reserva_id");

                movimentacao = new MovimentacaoReserva(id, valor, tipo_movimentacao, dt_movimentacao, reserva_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacao;
    }
}
