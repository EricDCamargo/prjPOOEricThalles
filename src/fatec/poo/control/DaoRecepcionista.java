/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class DaoRecepcionista {
    private Connection conn;

    public DaoRecepcionista(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Recepcionista recepcionista){
        PreparedStatement ps = null;
        try {
           ps = conn.prepareStatement("INSERT INTO tblRecepcionista(RegFunc_Recep, Nome_Recep, Endereco_Recep, Telefone_Recep, Turno_Recep) VALUES(?,?,?,?,?)");
           ps.setInt(1, recepcionista.getRegFunc());
           ps.setString(2, recepcionista.getNome());
           ps.setString(3, recepcionista.getEndereco());
           ps.setString(4, recepcionista.getTelefone());
           ps.setString(5, recepcionista.getTurno());
           
           
           ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
      public void alterar(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tblRecepcionista set Nome_Recep = ?, Endereco_Recep = ?, Telefone_Recep = ?, Turno_Recep = ? where RegFunc_Recep = ?" );
            
            ps.setString(1, recepcionista.getNome());
            ps.setString(2, recepcionista.getEndereco());
            ps.setString(3, recepcionista.getTelefone());
            ps.setString(4, recepcionista.getTurno());
            ps.setInt(5, recepcionista.getRegFunc());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
      
      public  Recepcionista consultar (int regFunc) {
        Recepcionista d = null;         
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblRecepcionista where " +
                                                 "RegFunc_Recep = ?");
            
            ps.setInt(1, regFunc);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                d = new Recepcionista (regFunc, rs.getString("Nome_Recep"));
                d.setEndereco(rs.getString("Endereco_Recep"));
                d.setTelefone(rs.getString("Telefone_Recep"));
                d.setTurno(rs.getString("Turno_Recep"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }
      
     public void excluir(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblRecepcionista where RegFunc_Recep = ?");
            
            ps.setInt(1, recepcionista.getRegFunc());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
      public ArrayList<Recepcionista> consultarDepartamentos(){
        ArrayList<Recepcionista> servicosQuarto = new ArrayList<Recepcionista>();
        int count = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblRecepcionista order by RegFunc_Recep");
                        
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                
                servicosQuarto.add(new Recepcionista (rs.getInt("RegFunc_Recep"),
                                                    rs.getString("Nome_Recep"))); 
                servicosQuarto.get(count).setEndereco(rs.getString("Endereco_Recep"));
                servicosQuarto.get(count).setTelefone(rs.getString("Telefone_Recep"));
                servicosQuarto.get(count).setTurno(rs.getString("Turno_Recep"));
                count++;
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }        
        return servicosQuarto;
     }
}
