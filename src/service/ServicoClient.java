package service;

import DAO.ClientDAO;
import model.Client;

import java.sql.SQLException;

public class ServicoClient {

    private ClientDAO clientDao = new ClientDAO();

    public void insertClient(Client entidade) {
        clientDao.insertClient(entidade);
    }

    public Client selectClient(int id) {
        return clientDao.selectClient(id);
    }

    public Boolean updateClient(Client entidade) {
        try {
            return clientDao.updateClient(entidade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteClient(int id) {
        try {
            if (clientDao.deleteClient(id)) {
                return true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}