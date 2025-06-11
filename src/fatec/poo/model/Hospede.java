package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Hospede extends Pessoa {
    private String cpf;
    private double taxaDesconto;
    private ArrayList<Registro> registros; 
    
    public Hospede(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
        this.registros = new ArrayList<>();
    }
    
    public void addRegistro(Registro registro) {
        registros.add(registro);
    }

    public void setTaxaDesconto(double taxaDesconto){
        this.taxaDesconto = taxaDesconto;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public double getTaxaDesconto(){
        return taxaDesconto;
    }
    
    public static String limparCPF(String cpf) {
        if (cpf == null) return "";
        return cpf.replaceAll("[^0-9]", "");
    }

    
    public static boolean validarCPF(String cpf) {
        if (cpf == null) return false;

        cpf = limparCPF(cpf.trim());

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0, weight = 10;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }
            int firstDigit = (sum * 10) % 11;
            if (firstDigit == 10) firstDigit = 0;

            sum = 0;
            weight = 11;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }
            int secondDigit = (sum * 10) % 11;
            if (secondDigit == 10) secondDigit = 0;

            return firstDigit == (cpf.charAt(9) - '0') && secondDigit == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }
}
}
