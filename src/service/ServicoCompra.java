package service;

import java.util.List;

import DAO.CompraDAO;
import model.Compra;

public class ServicoCompra {
    private CompraDAO compraDAO = new CompraDAO();

    public void insertCompra(Compra compra) {
        compraDAO.insert(compra);
    }

    public Compra selectCompra(int id) {
        return compraDAO.select(id);
    }

    public List<Compra> selectAllCompra() {
        return compraDAO.select();
    }

    public void deleteCompra(int id) {
        compraDAO.delete(id);
    }

    public void updateCompra(Compra Compra) {
        compraDAO.update(Compra);
    }
}
