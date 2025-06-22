/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thalles
 */
public class DaoRegistro {
    private Connection conn;
    
    public DaoRegistro(Connection conn){
        this.conn = conn;
    }
    
    public Registro consultar(int codigo){
        Registro dados = null;
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("SELECT * FROM tblRegistro where Codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
            }
            
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return(dados);
    } 
}
