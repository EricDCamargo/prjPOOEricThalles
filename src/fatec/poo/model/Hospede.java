package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Hospede extends Pessoa {
    private final String cpf;
    private double taxaDesconto;
    private final ArrayList<Registro> registros; 
    
    public Hospede(String cpf, String nome, Registro registro) {
        super(nome);
        this.cpf = cpf;
        this.registros = new ArrayList<>();
        this.registros.add(registro);
        registro.setHospede(this);
    }
    
    public void setTaxaDesconto(double taxaDesconto){
        this.taxaDesconto = taxaDesconto / 100;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public double getTaxaDesconto(){
        return taxaDesconto;
    }
}
