package service;

import DAO.TipoContaDAO;
import model.TipoConta;

import java.util.List;

public class ServicoTipoConta {
    
    private TipoContaDAO tipoContaDAO = new TipoContaDAO();

    public List<TipoConta> selectAllTipoContas(){
        return tipoContaDAO.selectAllTipoContas();
    }

    public TipoConta selectTipoConta(int id){
        return tipoContaDAO.selectTipoConta(id);
    }

    public void insertTipoConta(TipoConta tipoConta){
        tipoContaDAO.insertTipoConta(tipoConta);
    }

    public void deleteTipoConta(int id){
        tipoContaDAO.deleteTipoConta(id);
    }
}
