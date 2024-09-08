package model;

public class MovimentacaoCartao extends GenericModel {
    private int cartao_transacao_id;
    private String tipo_movimentacao;
    private double valor;
    private String dt_movimentacao;

    public MovimentacaoCartao(int cartao_transacao_id, String tipo_movimentacao, double valor, String dt_movimentacao) {
        this.cartao_transacao_id = cartao_transacao_id;
        this.tipo_movimentacao = tipo_movimentacao;
        this.valor = valor;
        this.dt_movimentacao = dt_movimentacao;
    }

    public MovimentacaoCartao(int id, int cartao_transacao_id, String tipo_movimentacao, double valor, String dt_movimentacao) {
        this(cartao_transacao_id, tipo_movimentacao, valor, dt_movimentacao);
        super.setId(id);
    }

    public int getCartaoTransacaoId() {
        return cartao_transacao_id;
    }

    public String getTipoMovimentacao() {
        return tipo_movimentacao;
    }

    public double getValor() {
        return valor;
    }

    public String getDtMovimentacao() {
        return dt_movimentacao;
    }

    public void setCartaoTransacaoId(int cartao_transacao_id) {
        this.cartao_transacao_id = cartao_transacao_id;
    }

    public void setTipoMovimentacao(String tipo_movimentacao) {
        this.tipo_movimentacao = tipo_movimentacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDtMovimentacao(String dt_movimentacao) {
        this.dt_movimentacao = dt_movimentacao;
    }

    @Override
    public String toString() {
        return "MovimentacaoCartao{" +
                "cartao_transacao_id=" + cartao_transacao_id +
                ", tipo_movimentacao='" + tipo_movimentacao + '\'' +
                ", valor=" + valor +
                ", dt_movimentacao='" + dt_movimentacao + '\'' +
                '}';
    }
}