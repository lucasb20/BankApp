package service;

import java.util.List;

import DAO.ContaDAO;
import model.Conta;

public class ServicoConta {
    private ContaDAO contaDAO = new ContaDAO();

    public void inserirConta(Conta conta) {
        contaDAO.insert(conta);
    }

    public Conta selectConta(int id) {
        return contaDAO.select(id);
    }

    public List<Conta> selectAllConta() {
        return contaDAO.select();
    }

    public void deleteConta(int id) {
        contaDAO.delete(id);
    }

    public void updateConta(Conta conta) {
        contaDAO.update(conta);
    }
}
