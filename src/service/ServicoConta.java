package service;

import DAO.ContaDAO;
import model.Conta;

public class ServicoConta {

    private ContaDAO contaDAO = new ContaDAO();

    public void insertConta(Conta entidade) {
        contaDAO.insertConta(entidade);
    }
}
