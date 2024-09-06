package model;

public class Client extends GenericModel {
    private String fator_risco;
    private double renda_mensal;
    private int pessoa_id;

    public Client(String fator_risco, double renda_mensal, int pessoa_id) {
        this.fator_risco = fator_risco;
        this.renda_mensal = renda_mensal;
        this.pessoa_id = pessoa_id;
    }

    public Client(int id, String fator_risco, double renda_mensal, int pessoa_id) {
        this(fator_risco, renda_mensal, pessoa_id);
        super.setId(id);
    }

    public String getFatorRisco() {
        return fator_risco;
    }

    public void setFatorRisco(String fator_risco) {
        this.fator_risco = fator_risco;
    }

    public double getRendaMensal() {
        return renda_mensal;
    }

    public void setRendaMensal(double renda_mensal) {
        this.renda_mensal = renda_mensal;
    }

    public int getPessoaId() {
        return pessoa_id;
    }

    public void setPessoaId(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    @Override
    public String toString() {
        return "Client {" +
                "id='" + this.getId() + "\'" +
                "fator risco='" + fator_risco + "\'" +
                "renda mensal='" + renda_mensal + "\'" +
                "pessoa id='" + pessoa_id + "\'" +
                '}';
    }
}
