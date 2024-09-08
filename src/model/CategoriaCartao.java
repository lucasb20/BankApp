package model;

public class CategoriaCartao extends GenericModel {
    private String descricao;

    public CategoriaCartao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaCartao(int id, String descricao) {
        this(descricao);
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CategoriaCartao{" +
                "id=" + super.getId() +
                "descricao='" + descricao + '\'' +
                '}';
    }
}