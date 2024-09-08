package model;

public class Conta extends GenericModel {
    private double saldo;
    private double limite_negativo;
    private int client_id;
    private int tipo_conta_id;

    public Conta(double saldo, double limite_negativo, int client_id, int tipo_conta_id) {
        this.saldo = saldo;
        this.limite_negativo = limite_negativo;
        this.client_id = client_id;
        this.tipo_conta_id = tipo_conta_id;
    }

    public Conta(int id, double saldo, double limite_negativo, int client_id, int tipo_conta_id) {
        this(saldo, limite_negativo, client_id, tipo_conta_id);
        super.setId(id);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteNegativo() {
        return limite_negativo;
    }

    public int getClientId() {
        return client_id;
    }

    public int getTipoContaId() {
        return tipo_conta_id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimiteNegativo(double limite_negativo) {
        this.limite_negativo = limite_negativo;
    }

    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    public void setTipoContaId(int tipo_conta_id) {
        this.tipo_conta_id = tipo_conta_id;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + super.getId() +
                ", saldo='" + saldo + '\'' +
                ", limite_negativo='" + limite_negativo + '\'' +
                ", client_id=" + client_id +
                ", tipo_conta_id=" + tipo_conta_id +
                '}';
    }
}
