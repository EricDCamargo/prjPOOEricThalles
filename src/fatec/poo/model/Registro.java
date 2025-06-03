package fatec.poo.model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Registro {
    private final int codigo;
    private final LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    private final Recepcionista recepcionista;
    private Hospede hospede;
    private Quarto quarto;
    private final ArrayList<ServicoQuarto> servicosQuarto; 
    

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista){
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
        this.servicosQuarto = new ArrayList<>();
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
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
    }
    
     public double liberarQuarto() {
        int dias = dataEntrada.until(dataSaida).getDays();
        this.valorHospedagem = quarto.liberar(dias);
        double valorDesconto = valorHospedagem * hospede.getTaxaDesconto();
        
        
        
        double totalServicos = 0;
        for (ServicoQuarto servico : servicosQuarto) {
            if (servico.getValor() <= 0) {
                throw new IllegalArgumentException("O valor do serviço '" + servico.getDescricao() + "' não foi definido corretamente.");
            }
        totalServicos += servico.getValor();
        }

        return (valorHospedagem - valorDesconto) + totalServicos;
    }

    public void addServicoQuarto(ServicoQuarto servico) {
        servicosQuarto.add(servico);
    }
    
}
