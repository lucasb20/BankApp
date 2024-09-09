package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.PagamentoDAO;
import model.Pagamento;

public class ServicoPagamento {
    private PagamentoDAO pagamentoDAO = new PagamentoDAO();

    public void insertPagamento(Pagamento pagamento) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        pagamento.setDtPagamento(data + " " + hora);
        pagamentoDAO.insert(pagamento);
    }

    public Pagamento selectPagamento(int id) {
        return pagamentoDAO.select(id);
    }

    public List<Pagamento> selectAllPagamento() {
        return pagamentoDAO.select();
    }

    public void updatePagamento(Pagamento pagamento) {
        pagamentoDAO.update(pagamento);
    }
}
