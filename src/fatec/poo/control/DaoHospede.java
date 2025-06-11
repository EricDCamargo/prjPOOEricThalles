/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ericd
 */
public class DaoHospede {
    private Connection conn;

    public DaoHospede(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Hospede hospede){
        PreparedStatement ps = null;
        try {
           ps = conn.prepareStatement("INSERT INTO tblHospede(Cpf_Hospede, Nome_Hospede, Endereco_Hospede, Telefone_Hospede, TaxaDesconto_Hospede) VALUES(?,?,?,?,?)");
           ps.setString(1, hospede.getCpf());
           ps.setString(2, hospede.getNome());
           ps.setString(3, hospede.getEndereco());
           ps.setString(4, hospede.getTelefone());
           ps.setDouble(5, hospede.getTaxaDesconto());
           
           
           ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
      public void alterar(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tblHospede set Nome_Hospede = ?, Endereco_Hospede = ?, Telefone_Hospede = ?, TaxaDesconto_Hospede = ? where Cpf_Hospede = ?" );
            
            ps.setString(1, hospede.getNome());
            ps.setString(2, hospede.getEndereco());
            ps.setString(3, hospede.getTelefone());
            ps.setDouble(4, hospede.getTaxaDesconto());
            ps.setString(5, hospede.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
      
      public Hospede consultar (String cpf) {
        Hospede d = null;         
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblHospede where " +
                                                 "Cpf_Hospede = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                d = new Hospede (cpf, rs.getString("Nome_Hospede"));     
                d.setEndereco(rs.getString("Endereco_Hospede"));
                d.setTelefone(rs.getString("Telefone_Hospede"));
                d.setTaxaDesconto(rs.getDouble("TaxaDesconto_Hospede"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }
      
     public void excluir(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblHospede where Cpf_Hospede = ?");
            
            ps.setString(1, hospede.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
