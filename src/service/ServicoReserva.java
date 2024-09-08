package service;

import java.util.List;

import DAO.ReservaDAO;
import model.Reserva;

public class ServicoReserva {
    private ReservaDAO reservaDAO = new ReservaDAO();

    public void insertReserva(Reserva reserva) {
        reservaDAO.insertReserva(reserva);
    }

    public Reserva selectReserva(int id) {
        return reservaDAO.selectReserva(id);
    }

    public void updateReserva(Reserva reserva) {
        reservaDAO.updateReserva(reserva);
    }

    public void deleteReserva(int id) {
        reservaDAO.deleteReserva(id);
    }

    public List<Reserva> selectAllReservas() {
        return reservaDAO.selectAllReservas();
    }
}
