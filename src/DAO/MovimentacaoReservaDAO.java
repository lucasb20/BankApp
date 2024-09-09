package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import model.MovimentacaoReserva;

import java.util.ArrayList;

public class MovimentacaoReservaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO movimentacao_reserva (valor, tipo_movimentacao, dt_movimentacao, reserva_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM movimentacao_reserva";
    private static final String UPDATE = "UPDATE movimentacao_reserva SET valor = ?, tipo_movimentacao = ?, dt_movimentacao = ? WHERE reserva_id = ?";
    private static final String SELECT_ID = "SELECT * FROM movimentacao_reserva WHERE id = ?";
    private static final String DELETE = "DELETE FROM movimentacao_reserva WHERE id = ?";
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

    public void insert(MovimentacaoReserva movimentacao) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setDouble(1, movimentacao.getValor());
            preparedStatement.setString(2, movimentacao.getTipoMovimentacao());
            preparedStatement.setString(3, movimentacao.getDtMovimentacao());
            preparedStatement.setInt(4, movimentacao.getReservaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(MovimentacaoReserva movimentacao) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setDouble(1, movimentacao.getValor());
            preparedStatement.setString(2, movimentacao.getTipoMovimentacao());
            preparedStatement.setString(3, movimentacao.getDtMovimentacao());
            preparedStatement.setInt(4, movimentacao.getReservaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public List<MovimentacaoReserva> select() {
        List<MovimentacaoReserva> movimentacoes = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double valor = rs.getDouble("valor");
                String tipo_movimentacao = rs.getString("tipo_movimentacao");
                String dt_movimentacao = rs.getString("dt_movimentacao");
                int reserva_id = rs.getInt("reserva_id");

                movimentacoes.add(new MovimentacaoReserva(id, valor, tipo_movimentacao, dt_movimentacao, reserva_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movimentacoes;
    }

    public MovimentacaoReserva select(int id) {
        MovimentacaoReserva movimentacao = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
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
