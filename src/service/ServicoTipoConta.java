package service;

import DAO.TipoContaDAO;
import model.TipoConta;

import java.util.List;

public class ServicoTipoConta {
    
    private TipoContaDAO tipoContaDAO = new TipoContaDAO();

    public List<TipoConta> selectAllTipoContas(){
        return tipoContaDAO.select();
    }

    public TipoConta selectTipoConta(int id){
        return tipoContaDAO.select(id);
    }

    public void insertTipoConta(TipoConta tipoConta){
        tipoContaDAO.insert(tipoConta);
    }

    public void deleteTipoConta(int id){
        tipoContaDAO.delete(id);
    }
}
