package service;

import DAO.PessoaDAO;
import model.Pessoa;

import java.sql.SQLException;
import java.util.List;

public class ServicoPessoa {

    private PessoaDAO pessoaDao = new PessoaDAO();

    public void insertPessoa(Pessoa entidade) {
        pessoaDao.insert(entidade);
    }

    public List<Pessoa> selectAllPessoas(){
        return pessoaDao.select();
    }

    public Pessoa selectPessoa(int id) {
        return pessoaDao.select(id);
    }

    public Boolean updatePessoa(Pessoa entidade) {
        try {
            return pessoaDao.update(entidade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deletePessoa(int id) {
        try {
            if (pessoaDao.delete(id)) {
                return true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}