package model;

public class ItensFatura extends GenericModel {
    private String descricao;
    private int fatura_cartao_id;

    public ItensFatura(String descricao, int fatura_cartao_id) {
        this.descricao = descricao;
        this.fatura_cartao_id = fatura_cartao_id;
    }

    public ItensFatura(int id, String descricao, int fatura_cartao_id) {
        this(descricao, fatura_cartao_id);
        super.setId(id);
    }

    public int getFaturaCartaoId() {
        return fatura_cartao_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setFaturaCartaoId(int fatura_cartao_id) {
        this.fatura_cartao_id = fatura_cartao_id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ItensFatura{" +
                "fatura_cartao_id=" + fatura_cartao_id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}