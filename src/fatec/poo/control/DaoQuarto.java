/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ericd
 */
public class DaoQuarto {
    
    private Connection conn;

    public DaoQuarto(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Quarto quarto){
        PreparedStatement ps = null;
        try {
           ps = conn.prepareStatement("INSERT INTO tblQuarto(Numero_Quarto, Tipo_Quarto, ValorDiaria_Quarto, Situacao_Quarto, TotalFaturado_Quarto) VALUES(?,?,?,?,?)");
           ps.setInt(1, quarto.getNumero());
           ps.setString(2, quarto.getTipo());
           ps.setDouble(3, quarto.getValorDiaria());
           ps.setBoolean(4, quarto.getSituacao());
           ps.setDouble(5, quarto.getTotalFaturado());
           
           
           ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
      public void alterar(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tblQuarto set Tipo_Quarto = ?, ValorDiaria_Quarto = ?, Situacao_Quarto = ?, TotalFaturado_Quarto = ? where Numero_Quarto = ?" );
            
            ps.setString(1, quarto.getTipo());
            ps.setDouble(2, quarto.getValorDiaria());
            ps.setBoolean(3, quarto.getSituacao());
            ps.setDouble(4, quarto.getTotalFaturado());
            ps.setInt(5, quarto.getNumero());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
      
      public Quarto consultar (int numeroQuarto) {
        Quarto d = null;         
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblQuarto where " +
                                                 "Numero_Quarto = ?");
            
            ps.setInt(1, numeroQuarto);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                d = new Quarto (numeroQuarto, rs.getString("Tipo_Quarto"), rs.getDouble("ValorDiaria_Quarto"));           
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }
      
     public void excluir(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblQuarto where Numero_Quarto = ?");
            
            ps.setInt(1, quarto.getNumero());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
      public ArrayList<Quarto> consultarServicosQuarto(){
        ArrayList<Quarto> servicosQuarto = new ArrayList<Quarto>();
        int count = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblQuarto order by Numero_Quarto");
                        
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                
                servicosQuarto.add(new Quarto(rs.getInt("Numero_Quarto"),
                                              rs.getString("Tipo_Quarto"), 
                                              rs.getDouble("ValorDiaria_Quarto"))); 
                count++;
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }        
        return servicosQuarto;
     }
}
