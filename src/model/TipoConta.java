package model;

public class TipoConta extends GenericModel {
    private String descricao;

    public TipoConta(String descricao) {
        this.descricao = descricao;
    }

    public TipoConta(int id, String descricao) {
        super.setId(id);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
