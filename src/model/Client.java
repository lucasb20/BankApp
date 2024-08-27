package model;

public class Conta extends GenericModel {
    private String nome;
    private String cpf;
    private double renda_mensal;
    private double saldo;
    private int tipo_conta_id;

    public Conta(String nome, String cpf, double renda_mensal, double saldo, int tipo_conta_id) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda_mensal = renda_mensal;
        this.saldo = saldo;
        this.tipo_conta_id = tipo_conta_id;
    }

    public Conta(Integer id, String nome, String cpf, double renda_mensal, double saldo, int tipo_conta_id) {
        this(String nome, String cpf, double renda_mensal, double saldo, int tipo_conta_id)
        super.setId(id);
    }

    // Fazer métodos especiais para alguns atributos
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Ajeitar
    @Override
    public String toString() {
        return "Conta {" +
                "id='" + this.getId() + "\'" +
                "cpf='" + cpf + "\'" +
                "renda_mensal='" + renda_mensal + "\'" +
                "saldo='" + saldo + "\'" +
                "tipo_conta='" + nome + "\'" +
                '}';
    }
}
