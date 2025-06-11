package fatec.poo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static ConexaoBanco instancia;
    private Connection conexao;
    private static final String URL = "jdbc:ucanaccess://C:\\Users\\ericd\\Documents\\Projects\\Fatec\\POO\\Trabalhos\\prjPOOEricThalles\\src\\fatec\\poo\\basededados\\prjPOOBD.accdb";

    private ConexaoBanco() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conexao = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar ao banco: " + ex.getMessage());
            conexao = null;
        }
    }

    public static ConexaoBanco getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBanco();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        }
    }
}