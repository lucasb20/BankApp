package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO extends ConexaoDB{
    private static final String INSERT_RESERVA_SQL = "INSERT INTO reserva (saldo, taxa, reservacol, conta_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_RESERVA_BY_ID = "SELECT * FROM reserva WHERE id = ?";
    private static final String SELECT_ALL_RESERVA = "SELECT * FROM reserva";
    private static final String UPDATE_RESERVA_SQL = "UPDATE reserva SET saldo = ?, taxa = ?, reservacol = ?, conta_id = ? WHERE id = ?";
    private static final String DELETE_RESERVA_SQL = "DELETE FROM reserva WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM reserva";

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

    public void insertReserva(Reserva entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESERVA_SQL)) {
            preparedStatement.setDouble(1, entidade.getSaldo());
            preparedStatement.setDouble(2, entidade.getTaxa());
            preparedStatement.setString(3, entidade.getReservacol());
            preparedStatement.setInt(4, entidade.getConta_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Reserva selectReserva(int id) {
        Reserva entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESERVA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double saldo = rs.getDouble("saldo");
                double taxa = rs.getDouble("taxa");
                String reservacol = rs.getString("reservacol");
                int conta_id = rs.getInt("conta_id");

                entidade = new Reserva(id, saldo, taxa, reservacol, conta_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public void updateReserva(Reserva entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_RESERVA_SQL)) {
            preparedStatement.setDouble(1, entidade.getSaldo());
            preparedStatement.setDouble(2, entidade.getTaxa());
            preparedStatement.setString(3, entidade.getReservacol());
            preparedStatement.setInt(4, entidade.getConta_id());
            preparedStatement.setInt(5, entidade.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteReserva(int id) {
        try (PreparedStatement preparedStatement = prepararSQL(DELETE_RESERVA_SQL)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reserva> selectAllReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESERVA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double saldo = rs.getDouble("saldo");
                double taxa = rs.getDouble("taxa");
                String reservacol = rs.getString("reservacol");
                int conta_id = rs.getInt("conta_id");

                Reserva reserva = new Reserva(id, saldo, taxa, reservacol, conta_id);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }
}
