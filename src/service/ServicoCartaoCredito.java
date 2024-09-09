package service;

import DAO.CartaoCreditoDAO;
import model.CartaoCredito;

public class ServicoCartaoCredito {
    private CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAO();
    
    public void insertCartaoCredito(CartaoCredito cartaoCredito) {
        cartaoCreditoDAO.insert(cartaoCredito);
    }

    public CartaoCredito selectCartaoCredito(int id) {
        return cartaoCreditoDAO.select(id);
    }

    public void updateCartaoCredito(CartaoCredito cartaoCredito) {
        cartaoCreditoDAO.update(cartaoCredito);
    }

    public void deleteCartaoCredito(int id) {
        cartaoCreditoDAO.delete(id);
    }
}
