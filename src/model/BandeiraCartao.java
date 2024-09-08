package model;

public class BandeiraCartao extends GenericModel {
    private String descricao;

    public BandeiraCartao(String descricao) {
        this.descricao = descricao;
    }

    public BandeiraCartao(int id, String descricao) {
        this(descricao);
        super.setId(id);
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "BandeiraCartao{" +
                "id=" + super.getId() +
                "descricao='" + descricao + '\'' +
                '}';
    }
}