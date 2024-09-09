package service;

import DAO.CartaoTransacaoDAO;
import model.CartaoTransacao;

import java.util.List;

public class ServicoCartaoTransacao {
    private CartaoTransacaoDAO cartaoTransacaoDAO = new CartaoTransacaoDAO();

    public List<CartaoTransacao> selectAllCartaoTransacao(){
        return cartaoTransacaoDAO.select();
    }

    public CartaoTransacao selectCartaoTransacao(int id){
        return cartaoTransacaoDAO.select(id);
    }

    public void insertCartaoTransacao(CartaoTransacao cartaoTransacao){
        cartaoTransacaoDAO.insert(cartaoTransacao);
    }

    public void updateCartaoTransacao(CartaoTransacao cartaoTransacao){
        cartaoTransacaoDAO.update(cartaoTransacao);
    }

    public void deleteCartaoTransacao(int id){
        cartaoTransacaoDAO.delete(id);
    }
}
