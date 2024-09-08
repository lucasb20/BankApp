package service;

import java.util.List;

import DAO.ContaDAO;
import model.Conta;

public class ServicoConta {
    private ContaDAO contaDAO = new ContaDAO();

    public void inserirConta(Conta conta) {
        contaDAO.insertConta(conta);
    }

    public Conta selectConta(int id) {
        return contaDAO.selectConta(id);
    }

    public List<Conta> selectAllConta() {
        return contaDAO.selectAllConta();
    }

    public void deleteConta(int id) {
        contaDAO.deleteConta(id);
    }

    public void updateConta(Conta conta) {
        contaDAO.updateConta(conta);
    }
}
