package model;

public class Pagamento extends GenericModel {
    private double valor_total;
    private String dt_pagamento;
    private int fatura_cartao_id;
    private double valor_parcial;
    private int boleto_customizado_id;

    public Pagamento(double valor_total, String dt_pagamento, int fatura_cartao_id, double valor_parcial, int boleto_customizado_id) {
        this.valor_total = valor_total;
        this.dt_pagamento = dt_pagamento;
        this.fatura_cartao_id = fatura_cartao_id;
        this.valor_parcial = valor_parcial;
        this.boleto_customizado_id = boleto_customizado_id;
    }

    public Pagamento(int id, double valor_total, String dt_pagamento, int fatura_cartao_id, double valor_parcial, int boleto_customizado_id) {
        this(valor_total, dt_pagamento, fatura_cartao_id, valor_parcial, boleto_customizado_id);
        super.setId(id);
    }

    public double getValorTotal() {
        return valor_total;
    }

    public String getDtPagamento() {
        return dt_pagamento;
    }

    public int getFaturaCartaoId() {
        return fatura_cartao_id;
    }

    public double getValorParcial() {
        return valor_parcial;
    }

    public int getBoletoCustomizadoId() {
        return boleto_customizado_id;
    }

    public void setValorTotal(double valor_total) {
        this.valor_total = valor_total;
    }

    public void setDtPagamento(String dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    public void setFaturaCartaoId(int fatura_cartao_id) {
        this.fatura_cartao_id = fatura_cartao_id;
    }

    public void setValorParcial(double valor_parcial) {
        this.valor_parcial = valor_parcial;
    }

    public void setBoletoCustomizadoId(int boleto_customizado_id) {
        this.boleto_customizado_id = boleto_customizado_id;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "valor_total=" + valor_total +
                ", dt_pagamento='" + dt_pagamento + '\'' +
                ", fatura_cartao_id=" + fatura_cartao_id +
                ", valor_parcial=" + valor_parcial +
                ", boleto_customizado_id=" + boleto_customizado_id +
                '}';
    }
}