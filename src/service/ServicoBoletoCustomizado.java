package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.BoletoCustomizadoDAO;
import model.BoletoCustomizado;

public class ServicoBoletoCustomizado {
    private BoletoCustomizadoDAO boletoCustomizadoDAO = new BoletoCustomizadoDAO();

    public void insertBoletoCustomizado(BoletoCustomizado boletoCustomizado) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        boletoCustomizado.setDtGeracao(data + " " + hora);
        boletoCustomizadoDAO.insert(boletoCustomizado);
    }

    public BoletoCustomizado selectBoletoCustomizado(int id) {
        return boletoCustomizadoDAO.select(id);
    }

    public List<BoletoCustomizado> selectAllBoletoCustomizado() {
        return boletoCustomizadoDAO.select();
    }

    public void updateBoletoCustomizado(BoletoCustomizado boletoCustomizado) {
        boletoCustomizadoDAO.update(boletoCustomizado);
    }

    public void deleteBoletoCustomizado(int id) {
        boletoCustomizadoDAO.delete(id);
    }
}
