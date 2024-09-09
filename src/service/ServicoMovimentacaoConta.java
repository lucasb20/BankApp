package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.MovimentacaoContaDAO;
import model.MovimentacaoConta;

public class ServicoMovimentacaoConta {
    private MovimentacaoContaDAO movimentacaoContaDAO = new MovimentacaoContaDAO();

    public void insertMovimentacaoConta(MovimentacaoConta entidade) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        entidade.setDtMovimentacao(data + " " + hora);
        movimentacaoContaDAO.insert(entidade);
    }

    public void updateMovimentacaoConta(MovimentacaoConta entidade) {
        movimentacaoContaDAO.update(entidade);
    }

    public List<MovimentacaoConta> selectAllMovimentacaoConta() {
        return movimentacaoContaDAO.select();
    }
}
