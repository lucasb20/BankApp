package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.MovimentacaoCartaoDAO;

import model.MovimentacaoCartao;

public class ServicoMovimentacaoCartao {
    private MovimentacaoCartaoDAO movimentacaoCartaoDAO = new MovimentacaoCartaoDAO();

    public void insertMovimentacaoCartao(MovimentacaoCartao movimentacaoCartao) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        movimentacaoCartao.setDtMovimentacao(hora + " " + data);
        movimentacaoCartaoDAO.insert(movimentacaoCartao);
    }

    public MovimentacaoCartao selectMovimentacaoCartao(int id) {
        return movimentacaoCartaoDAO.select(id);
    }

    public void updateMovimentacaoCartao(MovimentacaoCartao movimentacaoCartao) {
        movimentacaoCartaoDAO.update(movimentacaoCartao);
    }

    public List<MovimentacaoCartao> selectAllMovimentacaoCartao() {
        return movimentacaoCartaoDAO.select();
    }
}