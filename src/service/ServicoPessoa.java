package service;

import DAO.PessoaDAO;
import model.Pessoa;

import java.sql.SQLException;

public class ServicoPessoa {

    private PessoaDAO pessoaDao = new PessoaDAO();

    public void insertPessoa(Pessoa entidade) {
        pessoaDao.insertPessoa(entidade);
    }

    public Pessoa selectPessoa(int id) {
        return pessoaDao.selectPessoa(id);
    }

    public Boolean updatePessoa(Pessoa entidade) {
        try {
            return pessoaDao.updatePessoa(entidade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deletePessoa(int id) {
        try {
            if (pessoaDao.deletePessoa(id)) {
                return true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}