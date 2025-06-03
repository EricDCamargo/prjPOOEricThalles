package fatec.poo.model;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Recepcionista extends Pessoa {
    private final int regFunc;
    private String turno;
    
    public Recepcionista(int regFunc, String nome){
        super(nome);
        this.regFunc = regFunc;
    }
    
    public void setTurno(String turno){
        if (!turno.equals("M") && !turno.equals("T") && !turno.equals("N")) {
            throw new IllegalArgumentException("Turno inválido. Use 'M' para Manhã, 'T' para Tarde ou 'N' para Noite.");
        }
        this.turno = turno;
    }
    
    public int getRegFunc(){
        return regFunc;
    }
    
    public String getTurno(){
        return turno;
    }
}
