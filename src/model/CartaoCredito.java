package model;

public class CartaoCredito extends GenericModel {
    private String dt_fechamento;
    private double limite_credito;
    private int categoria_cartao_id;
    private int conta_id;

    public CartaoCredito(String dt_fechamento, double limite_credito, int categoria_cartao_id, int conta_id) {
        this.dt_fechamento = dt_fechamento;
        this.limite_credito = limite_credito;
        this.categoria_cartao_id = categoria_cartao_id;
        this.conta_id = conta_id;
    }

    public CartaoCredito(int id, String dt_fechamento, double limite_credito, int categoria_cartao_id, int conta_id) {
        this(dt_fechamento, limite_credito, categoria_cartao_id, conta_id);
        super.setId(id);
    }

    public String getDtFechamento() {
        return dt_fechamento;
    }

    public double getLimiteCredito() {
        return limite_credito;
    }

    public int getCategoriaCartaoId() {
        return categoria_cartao_id;
    }

    public int getContaId() {
        return conta_id;
    }

    public void setDtFechamento(String dt_fechamento) {
        this.dt_fechamento = dt_fechamento;
    }

    public void setLimiteCredito(double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public void setCategoriaCartaoId(int categoria_cartao_id) {
        this.categoria_cartao_id = categoria_cartao_id;
    }

    public void setContaId(int conta_id) {
        this.conta_id = conta_id;
    }
}