package service;

import java.util.List;

import DAO.BandeiraCartaoDAO;
import model.BandeiraCartao;

public class ServicoBandeiraCartao {
    private BandeiraCartaoDAO bandeiraCartaoDAO = new BandeiraCartaoDAO();

    public void insertBandeiraCartao(BandeiraCartao bandeiraCartao) {
        bandeiraCartaoDAO.insert(bandeiraCartao);
    }

    public BandeiraCartao selectBandeiraCartao(int id) {
        return bandeiraCartaoDAO.select(id);
    }

    public void deleteBandeiraCartao(int id) {
        bandeiraCartaoDAO.delete(id);
    }

    public List<BandeiraCartao> selectAllBandeiraCartao() {
        return bandeiraCartaoDAO.select();
    }
}
