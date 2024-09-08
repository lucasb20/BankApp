package model;

public class Reserva extends GenericModel{
    private double saldo;
    private double taxa;
    private String reservacol;
    private int conta_id;

    public Reserva(double saldo, double taxa, String reservacol, int conta_id) {
        this.saldo = saldo;
        this.taxa = taxa;
        this.reservacol = reservacol;
        this.conta_id = conta_id;
    }

    public Reserva(int id, double saldo, double taxa, String reservacol, int conta_id) {
        this(saldo, taxa, reservacol, conta_id);
        super.setId(id);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxa() {
        return taxa;
    }

    public String getReservacol() {
        return reservacol;
    }

    public int getConta_id() {
        return conta_id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public void setReservacol(String reservacol) {
        this.reservacol = reservacol;
    }

    public void setConta_id(int conta_id) {
        this.conta_id = conta_id;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "saldo=" + saldo +
                ", taxa=" + taxa +
                ", reservacol='" + reservacol + '\'' +
                ", conta_id=" + conta_id +
                '}';
    }
}
