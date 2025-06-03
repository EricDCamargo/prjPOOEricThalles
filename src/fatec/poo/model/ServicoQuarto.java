package fatec.poo.model;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class ServicoQuarto {
    private final int codigo;
    private final String descricao;
    private double valor;
    
    public ServicoQuarto(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public double getValor(){
        return valor;
    }
}
