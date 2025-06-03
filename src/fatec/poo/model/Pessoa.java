package fatec.poo.model;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Pessoa {
    private final String nome;
    private String endereco;
    private String telefone;
    
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
}
