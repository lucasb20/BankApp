package model;

public class ItensFatura extends GenericModel {
    private int fatura_cartao_id;
    private String descricao;

    public ItensFatura(int fatura_cartao_id, String descricao) {
        this.fatura_cartao_id = fatura_cartao_id;
        this.descricao = descricao;
    }

    public ItensFatura(int id, int fatura_cartao_id, String descricao) {
        this(fatura_cartao_id, descricao);
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