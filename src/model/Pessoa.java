package model;

public class Pessoa extends GenericModel {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(Integer id, String nome, String cpf) {
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
        return "Pessoa {" +
                "id='" + this.getId() + "\'" +
                "nome='" + nome + "\'" +
                "cpf='" + cpf + "\'" +
                '}';
    }
}
