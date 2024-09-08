package model;

public class Compra extends GenericModel {
    private int quantidade_parcela;
    private double valor;
    private int cartao_transacao_id;
    private int corretor_id;
    private double taxa_parcelamento;
    private String credor;
    private String dt_compra;

    public Compra(int quantidade_parcela, double valor, int cartao_transacao_id, int corretor_id, double taxa_parcelamento, String credor, String dt_compra) {
        this.quantidade_parcela = quantidade_parcela;
        this.valor = valor;
        this.cartao_transacao_id = cartao_transacao_id;
        this.corretor_id = corretor_id;
        this.taxa_parcelamento = taxa_parcelamento;
        this.credor = credor;
        this.dt_compra = dt_compra;
    }

    public Compra(int id, int quantidade_parcela, double valor, int cartao_transacao_id, int corretor_id, double taxa_parcelamento, String credor, String dt_compra) {
        this(quantidade_parcela, valor, cartao_transacao_id, corretor_id, taxa_parcelamento, credor, dt_compra);
        super.setId(id);
    }

    public int getQuantidadeParcela() {
        return quantidade_parcela;
    }

    public double getValor() {
        return valor;
    }

    public int getCartaoTransacaoId() {
        return cartao_transacao_id;
    }

    public int getCorretorId() {
        return corretor_id;
    }

    public double getTaxaParcelamento() {
        return taxa_parcelamento;
    }

    public String getCredor() {
        return credor;
    }

    public String getDtCompra() {
        return dt_compra;
    }

    public void setQuantidadeParcela(int quantidade_parcela) {
        this.quantidade_parcela = quantidade_parcela;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCartaoTransacaoId(int cartao_transacao_id) {
        this.cartao_transacao_id = cartao_transacao_id;
    }

    public void setCorretorId(int corretor_id) {
        this.corretor_id = corretor_id;
    }

    public void setTaxaParcelamento(double taxa_parcelamento) {
        this.taxa_parcelamento = taxa_parcelamento;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public void setDtCompra(String dt_compra) {
        this.dt_compra = dt_compra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + super.getId() +
                ", quantidade_parcela=" + quantidade_parcela +
                ", valor=" + valor +
                ", cartao_transacao + " + cartao_transacao_id +
                ", corretor_id=" + corretor_id +
                ", taxa_parcelamento=" + taxa_parcelamento +
                ", credor='" + credor + '\'' +
                ", dt_compra='" + dt_compra + '\'' +
                '}';
    }
}