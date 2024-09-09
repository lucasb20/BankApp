package service;

import java.util.List;

import DAO.ItensFaturaDAO;
import model.ItensFatura;

public class ServicoItensFatura {
    private ItensFaturaDAO itensFaturaDAO = new ItensFaturaDAO();

    public void insertItensFatura(ItensFatura itensFatura) {
        itensFaturaDAO.insert(itensFatura);
    }

    public ItensFatura selectItensFatura(int id) {
        return itensFaturaDAO.select(id);
    }

    public List<ItensFatura> selectAllItensFatura() {
        return itensFaturaDAO.select();
    }

    public void updateItensFatura(ItensFatura itensFatura) {
        itensFaturaDAO.update(itensFatura);
    }

    public void deleteItensFatura(int id) {
        itensFaturaDAO.delete(id);
    }
}
