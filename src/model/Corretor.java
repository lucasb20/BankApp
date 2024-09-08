package model;

public class Corretor extends GenericModel {
    private String nome;

    public Corretor(String nome) {
        this.nome = nome;
    }

    public Corretor(int id, String nome) {
        this(nome);
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Corretor{" +
                "id=" + super.getId() +
                "nome='" + nome + '\'' +
                '}';
    }
}