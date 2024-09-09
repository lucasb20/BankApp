package service;

import java.util.List;

import DAO.CategoriaCartaoDAO;
import model.CategoriaCartao;

public class ServicoCategoriaCartao {
    private CategoriaCartaoDAO categoriaCartaoDAO = new CategoriaCartaoDAO();

    public List<CategoriaCartao> selectAllCategoriaCartao(){
        return categoriaCartaoDAO.select();
    }

    public CategoriaCartao selectCategoriaCartao(int id){
        return categoriaCartaoDAO.select(id);
    }

    public void insertCategoriaCartao(CategoriaCartao categoriaCartao){
        categoriaCartaoDAO.insert(categoriaCartao);
    }

    public void deleteCategoriaCartao(int id){
        categoriaCartaoDAO.delete(id);
    }
}
