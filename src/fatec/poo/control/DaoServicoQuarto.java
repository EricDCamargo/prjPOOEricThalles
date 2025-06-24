/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;
import fatec.poo.model.ServicoQuarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ericd
 */
public class DaoServicoQuarto {
    
    private Connection conn;

    public DaoServicoQuarto(Connection conn) {
          this.conn = conn;
    }
    
    public void inserir (ServicoQuarto servicoQuarto){
        PreparedStatement ps = null;
        try {
           ps = conn.prepareStatement("INSERT INTO tblServicoQuarto(Codigo_ServQuarto, Descricao_ServQuarto, Valor_ServQuarto) VALUES(?,?,?)");
           ps.setInt(1, servicoQuarto.getCodigo());
           ps.setString(2, servicoQuarto.getDescricao());
           ps.setDouble(3, servicoQuarto.getValor());
           
           ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
      public void alterar(ServicoQuarto servicoQuarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tblServicoQuarto set Descricao_ServQuarto = ?, Valor_ServQuarto = ? where Codigo_ServQuarto = ?" );
            
            ps.setString(1, servicoQuarto.getDescricao());
            ps.setDouble(2, servicoQuarto.getValor());
            ps.setInt(3, servicoQuarto.getCodigo());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
      
      public  ServicoQuarto consultar (int codigo) {
        ServicoQuarto d = null;         
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblServicoQuarto where " +
                                                 "Codigo_ServQuarto = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                d = new ServicoQuarto (codigo, rs.getString("Descricao_ServQuarto"));
                d.setValor(rs.getDouble("Valor_ServQuarto"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }
      
     public void excluir(ServicoQuarto servicoQuarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblServicoQuarto where Codigo_ServQuarto = ?");
            
            ps.setInt(1, servicoQuarto.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
     public ArrayList<ServicoQuarto> consultarPorRegistro(int codigoRegistro) {
        ArrayList<ServicoQuarto> servicos = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT CodigoServQuarto_LS FROM tblListaServico WHERE CodigoRegistro_LS = ?");
            ps.setInt(1, codigoRegistro);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codServico = rs.getInt("CodigoServQuarto_LS");
                ServicoQuarto servico = consultar(codServico); 
                if (servico != null) {
                    servicos.add(servico);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar serviços do registro: " + ex.toString());
        }

        return servicos;
    }

     
      public ArrayList<ServicoQuarto> consultarServicosQuarto(){
        ArrayList<ServicoQuarto> servicosQuarto = new ArrayList<ServicoQuarto>();
        int count = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tblServicoQuarto order by Codigo_ServQuarto");
                        
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                
                servicosQuarto.add(new ServicoQuarto (rs.getInt("Codigo_ServQuarto"),
                                                    rs.getString("Descricao_ServQuarto"))); 
                servicosQuarto.get(count).setValor(rs.getDouble("Valor_ServQuarto"));
                count++;
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }        
        return servicosQuarto;
     }
}
