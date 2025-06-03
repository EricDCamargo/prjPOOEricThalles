package fatec.poo.model;

import java.time.LocalDate;

/**
 *
 * @author Thalles
 */
public class Registro {
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    private Recepcionista recepcionista;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista){
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
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
        quarto.getSituacao(); //Verificar a necessidade de criar um método set na Classe Quarto
    }
    
    public double liberarQuarto(Hospede hospede, Quarto quarto, double totalServicos){
        double valor = quarto.getValorDiaria();
        double desconto = hospede.getTaxaDesconto();
        valorHospedagem = valor * desconto + totalServicos;
        return valorHospedagem;
    }
    
}
