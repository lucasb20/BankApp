package model;

public class CartaoTransacao extends GenericModel {
    private String numero_cartao;
    private String cvc;
    private int cartao_id;
    private String tipo_cartao;
    private String nome_cartao;
    private String tipo_transacao;
    private boolean is_international;
    private int bandeira_cartao_id;

    public CartaoTransacao(String numero_cartao, String cvc, int cartao_id, String tipo_cartao, String nome_cartao, String tipo_transacao, boolean is_international, int bandeira_cartao_id) {
        this.numero_cartao = numero_cartao;
        this.cvc = cvc;
        this.cartao_id = cartao_id;
        this.tipo_cartao = tipo_cartao;
        this.nome_cartao = nome_cartao;
        this.tipo_transacao = tipo_transacao;
        this.is_international = is_international;
        this.bandeira_cartao_id = bandeira_cartao_id;
    }

    public CartaoTransacao(int id, String numero_cartao, String cvc, int cartao_id, String tipo_cartao, String nome_cartao, String tipo_transacao, boolean is_international, int bandeira_cartao_id) {
        this(numero_cartao, cvc, cartao_id, tipo_cartao, nome_cartao, tipo_transacao, is_international, bandeira_cartao_id);
        super.setId(id);
    }

    public String getNumeroCartao() {
        return numero_cartao;
    }

    public String getCvc() {
        return cvc;
    }

    public int getCartaoId() {
        return cartao_id;
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

    public boolean getIsInternational() {
        return is_international;
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

    public void setCartaoId(int cartao_id) {
        this.cartao_id = cartao_id;
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

    public void setIsInternational(boolean is_international) {
        this.is_international = is_international;
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
                ", cartao_id=" + cartao_id +
                ", tipo_cartao='" + tipo_cartao + '\'' +
                ", nome_cartao='" + nome_cartao + '\'' +
                ", tipo_transacao='" + tipo_transacao + '\'' +
                ", is_international=" + is_international +
                ", bandeira_cartao_id=" + bandeira_cartao_id +
                '}';
    }
}