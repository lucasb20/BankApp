package service;

import java.util.List;

import DAO.CorretorDAO;
import model.Corretor;

public class ServicoCorretor {
    private CorretorDAO corretorDAO = new CorretorDAO();

    public void insertCorretor(Corretor corretor) {
        corretorDAO.insert(corretor);
    }

    public Corretor selectCorretor(int id) {
        return corretorDAO.select(id);
    }

    public List<Corretor> selectAllCorretores() {
        return corretorDAO.select();
    }

    public void updateCorretor(Corretor corretor) {
        corretorDAO.update(corretor);
    }
}