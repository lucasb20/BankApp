package model;

public class FaturaCartao extends GenericModel{
    private String mes_referencia;
    private String ano_referencia;
    private double valor;
    private int cartao_credito_id;
    private String dt_pagamento;

    public FaturaCartao(String mes_referencia, String ano_referencia, double valor, int cartao_credito_id, String dt_pagamento) {
        this.mes_referencia = mes_referencia;
        this.ano_referencia = ano_referencia;
        this.valor = valor;
        this.cartao_credito_id = cartao_credito_id;
        this.dt_pagamento = dt_pagamento;
    }

    public FaturaCartao(int id, String mes_referencia, String ano_referencia, double valor, int cartao_credito_id, String dt_pagamento) {
        this(mes_referencia, ano_referencia, valor, cartao_credito_id, dt_pagamento);
        super.setId(id);
    }

    public String getMesReferencia() {
        return mes_referencia;
    }

    public String getAnoReferencia() {
        return ano_referencia;
    }

    public double getValor() {
        return valor;
    }

    public int getCartaoCreditoId() {
        return cartao_credito_id;
    }

    public String getDtPagamento() {
        return dt_pagamento;
    }

    public void setMesReferencia(String mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public void setAnoReferencia(String ano_referencia) {
        this.ano_referencia = ano_referencia;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCartaoCreditoId(int cartao_credito_id) {
        this.cartao_credito_id = cartao_credito_id;
    }

    public void setDtPagamento(String dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    @Override
    public String toString() {
        return "FaturaCartao{" +
                "mes_referencia='" + mes_referencia + '\'' +
                ", ano_referencia='" + ano_referencia + '\'' +
                ", valor=" + valor +
                ", cartao_credito_id=" + cartao_credito_id +
                ", dt_pagamento='" + dt_pagamento + '\'' +
                '}';
    }
}