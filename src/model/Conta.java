package model;

public class Conta extends GenericModel {
    private String nome;
    private String cpf;
    private double renda_mensal;
    private double saldo;
    private double divida;
    private String tipo_conta;

    public Conta(String nome, String cpf, double renda_mensal, double saldo, double divida, String tipo_conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda_mensal = renda_mensal;
        this.saldo = saldo;
        this.divida = divida;
        this.tipo_conta = tipo_conta;
    }

    public Conta(Integer id, String nome, String cpf, double renda_mensal, double saldo, double divida, String tipo_conta) {
        this(nome, cpf, renda_mensal, saldo, divida, tipo_conta);
        super.setId(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRenda_mensal() {
        return renda_mensal;
    }

    public void setRenda_mensal(double renda_mensal) {
        this.renda_mensal = renda_mensal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Conta {" +
                "id='" + this.getId() + "\'" +
                "cpf='" + cpf + "\'" +
                "renda_mensal='" + renda_mensal + "\'" +
                "saldo='" + saldo + "\'" +
                "divida='" + divida + "\'" +
                "tipo_conta='" + tipo_conta + "\'" +
                '}';
    }
}
