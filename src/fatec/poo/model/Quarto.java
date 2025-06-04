package fatec.poo.model;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Quarto {
   private final int numero;
   private final String tipo;
   private boolean situacao;
   private final double valorDiaria;
   private double totalFaturado;
   
   public Quarto(int numero, String tipo, double valorDiaria){
       if (!tipo.equals("S") && !tipo.equals("D")) {
        throw new IllegalArgumentException("Tipo de quarto inválido. Use 'S' para solteiro ou 'D' para casado.");
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
