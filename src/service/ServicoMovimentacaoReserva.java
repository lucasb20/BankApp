package service;

import DAO.MovimentacaoReservaDAO;

import model.MovimentacaoReserva;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServicoMovimentacaoReserva {
    private MovimentacaoReservaDAO movimentacaoReservaDAO = new MovimentacaoReservaDAO();

    public void insertMovimentacaoReserva(MovimentacaoReserva entidade) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        entidade.setDtMovimentacao(data + " " + hora);
        movimentacaoReservaDAO.insert(entidade);
    }

    public void updateMovimentacaoReserva(MovimentacaoReserva entidade) {
        movimentacaoReservaDAO.update(entidade);
    }

    public List<MovimentacaoReserva> selectAllMovimentacaoReserva() {
        return movimentacaoReservaDAO.select();
    }
}
