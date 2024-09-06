package model;

public class Conta extends GenericModel {
    private String nome;
    private String cpf;

    public Conta(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Conta(Integer id, String nome, String cpf) {
        this(nome, cpf);
        super.setId(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
                '}';
    }
}
