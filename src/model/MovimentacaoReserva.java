package model;

public class MovimentacaoReserva extends GenericModel{
    private double valor;
    private String tipo_movimentacao;
    private String dt_movimentacao;
    private int reserva_id;

    public MovimentacaoReserva(double valor, String tipo_movimentacao, String dt_movimentacao, int reserva_id){
        this.valor = valor;
        this.tipo_movimentacao = tipo_movimentacao;
        this.dt_movimentacao = dt_movimentacao;
        this.reserva_id = reserva_id;
    }

    public MovimentacaoReserva(int id, double valor, String tipo_movimentacao, String dt_movimentacao, int reserva_id){
        this(valor, tipo_movimentacao, dt_movimentacao, reserva_id);
        super.setId(id);
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public String getTipoMovimentacao(){
        return this.tipo_movimentacao;
    }

    public void setTipoMovimentacao(String tipo_movimentacao){
        this.tipo_movimentacao = tipo_movimentacao;
    }

    public String getDtMovimentacao(){
        return this.dt_movimentacao;
    }

    public void setDtMovimentacao(String dt_movimentacao){
        this.dt_movimentacao = dt_movimentacao;
    }

    public int getReservaId(){
        return this.reserva_id;
    }

    public void setReservaId(int reserva_id){
        this.reserva_id = reserva_id;
    }

    @Override
    public String toString(){
        return "MovimentacaoReserva{" +
                "id=" + super.getId() +
                ", valor=" + this.valor +
                ", tipo_movimentacao='" + this.tipo_movimentacao + '\'' +
                ", dt_movimentacao='" + this.dt_movimentacao + '\'' +
                ", reserva_id=" + this.reserva_id +
                '}';
    }
}
