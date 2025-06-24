package fatec.poo.model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Registro {
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    private Recepcionista recepcionista;
    private Hospede hospede;
    private Quarto quarto;
    private ArrayList<ServicoQuarto> servicosQuarto; 
    

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista){
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
        recepcionista.addRegistro(this);
        this.servicosQuarto = new ArrayList<>();
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
    public void setValorHospedagem(double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }
    
    
    public void reservarQuarto(Hospede hospede, Quarto quarto){
        this.hospede = hospede;
        this.quarto = quarto;
        quarto.reservar();
        hospede.addRegistro(this);
    }
    
     public double liberarQuarto() {
        int dias = dataEntrada.until(dataSaida).getDays();
        this.valorHospedagem = quarto.liberar(dias);
        double valorDesconto = valorHospedagem * (hospede.getTaxaDesconto() / 100);
        
        double totalServicos = 0;
        for (ServicoQuarto servico : servicosQuarto) {
            totalServicos += servico.getValor();
        }

        return (valorHospedagem - valorDesconto) + totalServicos;
    }

    public void addServicoQuarto(ServicoQuarto servico) {
        servicosQuarto.add(servico);
    }
    
}
