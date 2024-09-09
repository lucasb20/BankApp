package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.FaturaCartaoDAO;

import model.FaturaCartao;

public class ServicoFaturaCartao {
    private FaturaCartaoDAO faturaCartaoDAO = new FaturaCartaoDAO();

    public void insertFaturaCartao(FaturaCartao faturaCartao) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        faturaCartao.setDtPagamento(data + " " + hora);
        faturaCartaoDAO.insert(faturaCartao);
    }

    public FaturaCartao selectFaturaCartao(int id) {
        return faturaCartaoDAO.select(id);
    }

    public List<FaturaCartao> selectAllFaturaCartao() {
        return faturaCartaoDAO.select();
    }

    public void updateFaturaCartao(FaturaCartao faturaCartao) {
        faturaCartaoDAO.update(faturaCartao);
    }
}