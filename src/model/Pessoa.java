package model;

public class Conta extends GenericModel {
    private String nome;
    private String cpf;
    private double renda_mensal;
    private double saldo;

    public Conta(String nome, String cpf, double renda_mensal, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda_mensal = renda_mensal;
        this.saldo = saldo;
    }

    public Conta(Integer id, String nome, String cpf, double renda_mensal, double saldo) {
        this(nome, cpf, renda_mensal, saldo);
        super.setId(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRendaMensal() {
        return renda_mensal;
    }

    public void setRendaMensal(double renda_mensal) {
        this.renda_mensal = renda_mensal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
                '}';
    }
}
