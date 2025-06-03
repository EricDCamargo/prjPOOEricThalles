package fatec.poo.model;

import java.time.temporal.ChronoUnit;

/**
 *
 * @author Thalles
 */
public class Quarto {
   private int numero;
   private String tipo;
   private boolean situacao;
   private double valorDiaria;
   private double totalFaturado;
   private Registro registro;
   
   public Quarto(int numero, String tipo, double valorDiaria){
       this.numero = numero;
       this.tipo = tipo;
       this.valorDiaria = valorDiaria;
   }
   
    private void reservar(){
        situacao = true;
    }
    
    private double liberar(int qtdDias){
        qtdDias = (int) ChronoUnit.DAYS.between(registro.getDataEntrada(), 
                                                registro.getDataSaida());
        situacao = false;
        double valorHospedagem = valorDiaria * qtdDias;
        totalFaturado += valorHospedagem;
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
