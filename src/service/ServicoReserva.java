package service;

import java.util.List;

import DAO.ReservaDAO;
import model.Reserva;

public class ServicoReserva {
    private ReservaDAO reservaDAO = new ReservaDAO();

    public void insertReserva(Reserva reserva) {
        reservaDAO.insert(reserva);
    }

    public Reserva selectReserva(int id) {
        return reservaDAO.select(id);
    }

    public void updateReserva(Reserva reserva) {
        reservaDAO.update(reserva);
    }

    public void deleteReserva(int id) {
        reservaDAO.delete(id);
    }

    public List<Reserva> selectAllReservas() {
        return reservaDAO.select();
    }
}
