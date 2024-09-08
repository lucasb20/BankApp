package model;

class MovimentacaoConta extends GenericModel {
    private double valor;
    private String dt_movimentacao;
    private String tipoMovimentacao;
    private int conta_id;

    public MovimentacaoConta(double valor, String dt_movimentacao, String tipoMovimentacao, int conta_id) {
        this.valor = valor;
        this.dt_movimentacao = dt_movimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.conta_id = conta_id;
    }

    public MovimentacaoConta(int id, double valor, String dt_movimentacao, String tipoMovimentacao, int conta_id) {
        this(valor, dt_movimentacao, tipoMovimentacao, conta_id);
        super.setId(id);
    }

    public double getValor() {
        return valor;
    }

    public String getDtMovimentacao() {
        return dt_movimentacao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public int getContaId() {
        return conta_id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDtMovimentacao(String dt_movimentacao) {
        this.dt_movimentacao = dt_movimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public void setContaId(int conta_id) {
        this.conta_id = conta_id;
    }
}