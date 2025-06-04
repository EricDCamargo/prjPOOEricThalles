package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Recepcionista extends Pessoa {
    private final int regFunc;
    private String turno;
    private final ArrayList<Registro> registros;
    
    public Recepcionista(int regFunc, String nome){
        super(nome);
        this.regFunc = regFunc;
        this.registros = new ArrayList<>();
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
    
    public void addRegistro(Registro registro) {
        registros.add(registro);
    }
}
