package fatec.poo.model;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Hospede extends Pessoa {
    private final String cpf;
    private double taxaDesconto;

    public Hospede(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
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
