import java.util.Date;

public class PassagemAerea {
    private Aeroporto origem;
    private Aeroporto destino;
    private Date dataHora;
    private String codigoVoo;
    private CompanhiaAerea companhia;
    private double valorTarifaBasica;
    private double valorTarifaBusiness;
    private double valorTarifaPremium;

    // Construtor
    public PassagemAerea(Aeroporto origem, Aeroporto destino, Date dataHora, String codigoVoo,
                         CompanhiaAerea companhia, double valorTarifaBasica, double valorTarifaBusiness, double valorTarifaPremium) {
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.codigoVoo = codigoVoo;
        this.companhia = companhia;
        this.valorTarifaBasica = valorTarifaBasica;
        this.valorTarifaBusiness = valorTarifaBusiness;
        this.valorTarifaPremium = valorTarifaPremium;
    }

    // Getters e Setters
    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public CompanhiaAerea getCompanhia() {
        return companhia;
    }

    public void setCompanhia(CompanhiaAerea companhia) {
        this.companhia = companhia;
    }

    public double getValorTarifaBasica() {
        return valorTarifaBasica;
    }

    public void setValorTarifaBasica(double valorTarifaBasica) {
        this.valorTarifaBasica = valorTarifaBasica;
    }

    public double getValorTarifaBusiness() {
        return valorTarifaBusiness;
    }

    public void setValorTarifaBusiness(double valorTarifaBusiness) {
        this.valorTarifaBusiness = valorTarifaBusiness;
    }

    public double getValorTarifaPremium() {
        return valorTarifaPremium;
    }

    public void setValorTarifaPremium(double valorTarifaPremium) {
        this.valorTarifaPremium = valorTarifaPremium;
    }

    // Métodos get para AeroportoOrigem e AeroportoDestino
    public Aeroporto getAeroportoOrigem() {
        return origem;
    }

    public Aeroporto getAeroportoDestino() {
        return destino;
    }

    // Método toString
    @Override
    public String toString() {
        return "PassagemAerea [Origem: " + origem + ", Destino: " + destino + ", Data e Hora: " + dataHora + "]";
    }
}
