
import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.model.ServicoQuarto;
import java.time.LocalDate;

/**
 *
 * @author Eric Camargo e Thalles Santana - Fatec Itu (2025)
 */
public class Aplic {
    public static void main(String[] args) {
        Quarto quarto = new Quarto(101, "D", 150);
        Recepcionista recepcionista = new Recepcionista(123, "The Eric");
        Registro registro = new Registro(1, LocalDate.of(2025, 6, 3), recepcionista);
        
        Hospede hospede = new Hospede("123.123.123.12", "The Thalles");

        hospede.setTaxaDesconto(10);
        registro.reservarQuarto(hospede, quarto);
        registro.setDataSaida(LocalDate.of(2025, 6, 7));
        
        ServicoQuarto cafeDaManha = new ServicoQuarto(1, "Café da manhã");
        cafeDaManha.setValor(30.0);
        
        registro.addServicoQuarto(cafeDaManha);
        
        System.out.println("Total a pagar: R$" + registro.liberarQuarto());
    }
    
}
