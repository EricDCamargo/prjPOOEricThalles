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
       this.numero = numero;
       this.tipo = tipo;
       this.valorDiaria = valorDiaria;
   }
   
    public void reservar() {
        this.situacao = true;
    }
    
    public double liberar(int qtdDias){
        this.situacao = false;
        this.totalFaturado += qtdDias * this.valorDiaria;
        return totalFaturado;
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
