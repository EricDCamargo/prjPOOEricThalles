/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Thalles
 */
public class DaoRegistro {
    private Connection conn;
    
    public DaoRegistro(Connection conn){
        this.conn = conn;
    }
    
    public Registro consultar(int codigo) {
        Registro objRegistro = null;
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement("SELECT * from tblRegistro WHERE Codigo_Registro = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                DaoRecepcionista daoRecep = new DaoRecepcionista(conn);
                DaoHospede daoHosp = new DaoHospede(conn);
                DaoQuarto daoQuarto = new DaoQuarto(conn);
                
                Recepcionista objRecep = daoRecep.consultar(rs.getInt("RegFuncRecep_Registro"));
                Hospede objHosp = daoHosp.consultar(rs.getString("CpfHospede_Registro"));
                Quarto objQuarto = daoQuarto.consultar(rs.getInt("NumeroQuarto_Registro"));
                
                LocalDate dataEntrada = rs.getDate("DataEntrada_Registro").toLocalDate();
                
                objRegistro = new Registro(rs.getInt("Codigo_Registro"), 
                        rs.getDate("DataEntrada_Registro").toLocalDate(), 
                        objRecep
                );
                objRegistro.setHospede(objHosp);
                objRegistro.setQuarto(objQuarto);
                
                //consulta os serviços de quarto que esse registro usou, instancia e insere no registro 
                DaoServicoQuarto daoServico = new DaoServicoQuarto(conn);
                ArrayList<ServicoQuarto> servicos = daoServico.consultarPorRegistro(objRegistro.getCodigo());

                for (ServicoQuarto s : servicos) {
                    objRegistro.addServicoQuarto(s);
                }

               
                Date dataSaida = rs.getDate("DataSaida_Registro");
                if (dataSaida != null) {
                objRegistro.setDataSaida(dataSaida.toLocalDate());
                }
                
                objRegistro.setValorHospedagem(rs.getDouble("ValorHospedagem_Registro"));
            }   
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (objRegistro);
    }
    
    
    public void reservar (Registro objRegistro) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO tblRegistro(Codigo_Registro, DataEntrada_Registro, DataSaida_Registro, ValorHospedagem_Registro, CpfHospede_Registro, NumeroQuarto_Registro, RegFuncRecep_Registro) VALUES(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, objRegistro.getCodigo());
            ps.setDate(2, Date.valueOf(objRegistro.getDataEntrada()));
            // checa se o valor já existe
            if (objRegistro.getDataSaida()!= null) {
                ps.setDate(3, Date.valueOf(objRegistro.getDataSaida()));
            } else {
                ps.setDate(3, null);
            }
            ps.setDouble(4, objRegistro.getValorHospedagem());
            ps.setString(5, objRegistro.getHospede().getCpf());
            ps.setInt(6, objRegistro.getQuarto().getNumero());
            ps.setInt(7, objRegistro.getRecepcionista().getRegFunc());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void liberar(Registro registro) {
        PreparedStatement ps;
        
        try {
            LocalDate dataSaída = registro.getDataSaida();
            double valorFinal = registro.liberarQuarto();
            
            ps = conn.prepareStatement("UPDATE tblRegistro SET DataSaida_Registro = ?, ValorHospedagem_Registro = ? WHERE Codigo_Registro = ?");
            
            ps.setDate(1, Date.valueOf(dataSaída));
            ps.setDouble(2, valorFinal);
            ps.setInt(3, registro.getCodigo());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
