package service;

import DAO.ContaDAO;
import model.Conta;

import java.sql.SQLException;

public class ServicoConta {

    private ContaDAO contaDAO = new ContaDAO();

    public void insertConta(Conta entidade) {
        contaDAO.insertConta(entidade);
    }

    public Conta selectConta(int id) {
        return contaDAO.selectConta(id);
    }

    public Boolean updateConta(Conta entidade) throws SQLException {
        return contaDAO.updateConta(entidade);
    }
}