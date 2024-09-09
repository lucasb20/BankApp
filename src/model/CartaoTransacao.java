package model;

public class CartaoTransacao extends GenericModel {
    private String numero_cartao;
    private String cvc;
    private int cartao_credito_id;
    private String tipo_cartao;
    private String nome_cartao;
    private String tipo_transacao;
    private int is_internacional;
    private int bandeira_cartao_id;

    public CartaoTransacao(String numero_cartao, String cvc, int cartao_credito_id, String tipo_cartao, String nome_cartao, String tipo_transacao, int is_internacional, int bandeira_cartao_id) {
        this.numero_cartao = numero_cartao;
        this.cvc = cvc;
        this.cartao_credito_id = cartao_credito_id;
        this.tipo_cartao = tipo_cartao;
        this.nome_cartao = nome_cartao;
        this.tipo_transacao = tipo_transacao;
        this.is_internacional = is_internacional;
        this.bandeira_cartao_id = bandeira_cartao_id;
    }

    public CartaoTransacao(int id, String numero_cartao, String cvc, int cartao_id, String tipo_cartao, String nome_cartao, String tipo_transacao, int is_internacional, int bandeira_cartao_id) {
        this(numero_cartao, cvc, cartao_id, tipo_cartao, nome_cartao, tipo_transacao, is_internacional, bandeira_cartao_id);
        super.setId(id);
    }

    public String getNumeroCartao() {
        return numero_cartao;
    }

    public String getCvc() {
        return cvc;
    }

    public int getCartaoCreditoId() {
        return cartao_credito_id;
    }

    public String getTipoCartao() {
        return tipo_cartao;
    }

    public String getNomeCartao() {
        return nome_cartao;
    }

    public String getTipoTransacao() {
        return tipo_transacao;
    }

    public int getIsInternacional() {
        return is_internacional;
    }

    public int getBandeiraCartaoId() {
        return bandeira_cartao_id;
    }

    public void setNumeroCartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public void setCartaoCreditoId(int cartao_id) {
        this.cartao_credito_id = cartao_id;
    }

    public void setTipoCartao(String tipo_cartao) {
        this.tipo_cartao = tipo_cartao;
    }

    public void setNomeCartao(String nome_cartao) {
        this.nome_cartao = nome_cartao;
    }

    public void setTipoTransacao(String tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }

    public void setIsInternational(int is_internacional) {
        this.is_internacional = is_internacional;
    }

    public void setBandeiraCartaoId(int bandeira_cartao_id) {
        this.bandeira_cartao_id = bandeira_cartao_id;
    }

    @Override
    public String toString() {
        return "CartaoTransacao{" +
                "id=" + super.getId() +
                ", numero_cartao='" + numero_cartao + '\'' +
                ", cvc='" + cvc + '\'' +
                ", cartao_credito_id=" + cartao_credito_id +
                ", tipo_cartao='" + tipo_cartao + '\'' +
                ", nome_cartao='" + nome_cartao + '\'' +
                ", tipo_transacao='" + tipo_transacao + '\'' +
                ", is_internacional=" + is_internacional +
                ", bandeira_cartao_id=" + bandeira_cartao_id +
                '}';
    }
}