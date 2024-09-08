package service;

import DAO.ClientDAO;
import model.Client;

import java.sql.SQLException;
import java.util.List;

public class ServicoClient {

    private ClientDAO clientDao = new ClientDAO();

    private String calcFatorRisco (double renda_mensal){
        if (renda_mensal < 2000){
            Double fator_risco = renda_mensal / 2000;
            return fator_risco.toString();
        }
        else{
            return "0.0";
        }
    }

    public void insertClient(Client entidade) {
        String fator_risco = calcFatorRisco(entidade.getRendaMensal());
        entidade.setFatorRisco(fator_risco);
        clientDao.insertClient(entidade);
    }

    public List<Client> selectAllClients(){
        return clientDao.selectAllClients();
    }

    public Client selectClient(int id) {
        return clientDao.selectClient(id);
    }

    public Boolean updateClient(Client entidade) {
        try {
            entidade.setFatorRisco(calcFatorRisco(entidade.getRendaMensal()));
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