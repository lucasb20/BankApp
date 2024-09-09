package service;

import java.util.List;

import DAO.TipoBoletoCustomizadoDAO;
import model.TipoBoletoCustomizado;

public class ServicoTipoBoletoCustomizado {
    private TipoBoletoCustomizadoDAO tipoBoletoCustomizadoDAO = new TipoBoletoCustomizadoDAO();

    public void insertTipoBoletoCustomizado(TipoBoletoCustomizado tipoBoletoCustomizado) {
        tipoBoletoCustomizadoDAO.insert(tipoBoletoCustomizado);
    }

    public TipoBoletoCustomizado selectTipoBoletoCustomizado(int id) {
        return tipoBoletoCustomizadoDAO.select(id);
    }

    public List<TipoBoletoCustomizado> selectAllTipoBoletoCustomizado() {
        return tipoBoletoCustomizadoDAO.select();
    }

    public void deleteTipoBoletoCustomizado(int id) {
        tipoBoletoCustomizadoDAO.delete(id);
    }
}
