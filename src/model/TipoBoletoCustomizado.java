package model;

public class TipoBoletoCustomizado extends GenericModel {
    private String descricao;

    public TipoBoletoCustomizado(String descricao) {
        this.descricao = descricao;
    }

    public TipoBoletoCustomizado(int id, String descricao) {
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
        return "TipoBoletoCustomizado{" +
                "id=" + super.getId() +
                "descricao='" + descricao + '\'' +
                '}';
    }
}