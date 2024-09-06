package service;

import DAO.PessoaDAO;
import model.Pessoa;

import java.sql.SQLException;

public class ServicoPessoa {

    private PessoaDao pessoaDao = new PessoaDao();

    public void insertPessoa(Pessoa entidade) {
        pessoaDao.insertPessoa(entidade);
    }

    public Pessoa selectPessoa(int id) {
        return pessoaDao.selectPessoa(id);
    }

    public Boolean updatePessoa(Pessoa entidade) throws SQLException {
        return pessoaDao.updatePessoa(entidade);
    }

    public Boolean deletePessoa(int id){
        return pessoaDao.deletePessoa(id);
    }
}