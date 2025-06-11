/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.utils;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ericd
 */
public class Helper {
    
    //recebe o campo e valida se seu valor é real, se verdadeiro retorna true, se falso retorna mensagem de aviso
    public static boolean isValidDouble(JTextField textField) {
        String valorEntrada = textField.getText().trim();
        
        if (valorEntrada.isEmpty() || !valorEntrada.matches("\\d+(\\.\\d+)?")) { 
            JOptionPane.showMessageDialog(null, 
                "Valor inválido! O campo '" + textField.getName() + "' deve conter um número real.", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            textField.setText(null);
            return false;
        }
        
        return true;
    }
    //recebe o campo e valida se seu valor é inteiro, se verdadeiro retorna true, se falso retorna mensagem de aviso
    public static boolean isValidInteger(JTextField textField) {
        String valorEntrada = textField.getText().trim();
        
        if (valorEntrada.isEmpty() || !valorEntrada.matches("\\d+")) { 
            JOptionPane.showMessageDialog(null, 
                "Valor inválido! O campo '" + textField.getName() + "' deve conter um número inteiro.", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            textField.setText(null);
            return false;
        }
        
        return true;
    }
    //verifica se o campo esta vazio, se vazio apresenta mensagem de aviso e posiciona o foco no campo
    public static boolean isCampoPreenchido(JTextField textField) {
    if (textField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo '" + textField.getName() + "' é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
        textField.requestFocus();
        textField.setText(null);
        return false;
    }
    return true;
}

}