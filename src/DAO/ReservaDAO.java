package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO extends ConexaoDB{
    private static final String INSERT = "INSERT INTO reserva (saldo, taxa, reservacol, conta_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ID = "SELECT * FROM reserva WHERE id = ?";
    private static final String SELECT = "SELECT * FROM reserva";
    private static final String UPDATE = "UPDATE reserva SET saldo = ?, taxa = ?, reservacol = ?, conta_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM reserva WHERE id = ?";
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

    public void insert(Reserva entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
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

    public Reserva select(int id) {
        Reserva entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
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

    public void update(Reserva entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
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

    public List<Reserva> select() {
        List<Reserva> reservas = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
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
