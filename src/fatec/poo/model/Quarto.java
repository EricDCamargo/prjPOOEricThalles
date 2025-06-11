package fatec.poo.model;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Quarto {
   private final int numero;
   private String tipo;
   private boolean situacao;
   private double valorDiaria;
   private double totalFaturado;
   
   public Quarto(int numero, String tipo, double valorDiaria){
       if (!tipo.equals("S") && !tipo.equals("C")) {
        throw new IllegalArgumentException("Tipo de quarto inválido. Use 'S' para solteiro ou 'C' para casado.");
    }
       this.numero = numero;
       this.tipo = tipo;
       this.valorDiaria = valorDiaria;
   }
   
    public void reservar() {
        this.situacao = true;
    }
    
    public double liberar(int qtdDias){
        if (qtdDias <= 0) {
        throw new IllegalArgumentException("A quantidade de dias deve ser maior que zero.");
    }
        this.situacao = false;
        double valorHospedagem = qtdDias * this.valorDiaria;
        this.totalFaturado += valorHospedagem;
        return valorHospedagem;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setTotalFaturado(double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }    
}
