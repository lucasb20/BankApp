package service;

import DAO.MovimentacaoReservaDAO;

import model.MovimentacaoReserva;

import java.util.List;

public class ServicoMovimentacaoReserva {
    private MovimentacaoReservaDAO movimentacaoReservaDAO = new MovimentacaoReservaDAO();

    public void insertMovimentacaoReserva(double valor, String tipo_movimentacao, String dt_movimentacao, int reserva_id) {
        movimentacaoReservaDAO.insertMovimentacaoReserva(valor, tipo_movimentacao, dt_movimentacao, reserva_id);
    }

    public void updateMovimentacaoReserva(double valor, String tipo_movimentacao, String dt_movimentacao, int reserva_id) {
        movimentacaoReservaDAO.updateMovimentacaoReserva(valor, tipo_movimentacao, dt_movimentacao, reserva_id);
    }

    public List<MovimentacaoReserva> selectAllMovimentacaoReserva(int reserva_id) {
        return movimentacaoReservaDAO.selectAllMovimentacaoReserva(reserva_id);
    }
}
