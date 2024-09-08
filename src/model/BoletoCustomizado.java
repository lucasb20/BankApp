package model;

public class BoletoCustomizado extends GenericModel{
    
    private double valor;
    private String dt_vencimento;
    private String dt_geracao;
    private String codigo_barras;
    private int tipo_boleto_customizado_id;
    private int fatura_cartao_id;

    public BoletoCustomizado(double valor, String dt_vencimento, String dt_geracao, String codigo_barras, int tipo_boleto_customizado_id, int fatura_cartao_id) {
        this.valor = valor;
        this.dt_vencimento = dt_vencimento;
        this.dt_geracao = dt_geracao;
        this.codigo_barras = codigo_barras;
        this.tipo_boleto_customizado_id = tipo_boleto_customizado_id;
        this.fatura_cartao_id = fatura_cartao_id;
    }

    public BoletoCustomizado(int id, double valor, String dt_vencimento, String dt_geracao, String codigo_barras, int tipo_boleto_customizado_id, int fatura_cartao_id) {
        this(valor, dt_vencimento, dt_geracao, codigo_barras, tipo_boleto_customizado_id, fatura_cartao_id);
        super.setId(id);
    }

    public double getValor() {
        return valor;
    }

    public String getDtVencimento() {
        return dt_vencimento;
    }

    public String getDtGeracao() {
        return dt_geracao;
    }

    public String getCodigoBarras() {
        return codigo_barras;
    }

    public int getTipoBoletoCustomizadoId() {
        return tipo_boleto_customizado_id;
    }

    public int getFaturaCartaoId() {
        return fatura_cartao_id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDtVencimento(String dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public void setDtGeracao(String dt_geracao) {
        this.dt_geracao = dt_geracao;
    }

    public void setCodigoBarras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public void setTipoBoletoCustomizadoId(int tipo_boleto_customizado_id) {
        this.tipo_boleto_customizado_id = tipo_boleto_customizado_id;
    }

    public void setFaturaCartaoId(int fatura_cartao_id) {
        this.fatura_cartao_id = fatura_cartao_id;
    }

    @Override
    public String toString() {
        return "BoletoCustomizado{" +
                "valor=" + valor +
                ", dt_vencimento='" + dt_vencimento + '\'' +
                ", dt_geracao='" + dt_geracao + '\'' +
                ", codigo_barras='" + codigo_barras + '\'' +
                ", tipo_boleto_customizado_id=" + tipo_boleto_customizado_id +
                ", fatura_cartao_id=" + fatura_cartao_id +
                '}';
    }
}