
import CodificationDecodification.CriptografaDescriptografa;
import java.util.Scanner;

public class Teste {
    
    public static void main(String[] args) {
        CriptografaDescriptografa cd = new CriptografaDescriptografa();
                
        String texto;
        Scanner recebe = new Scanner(System.in);
        
        System.out.println("Digite o texto para ser cripografado...");
        System.out.println("Digite : ");
        texto = recebe.nextLine();
        
        System.out.println("\nTexto digitado : " + texto);
        System.out.println("Texto Criptografado : " + cd.CodificaTexto(texto));
        
        System.out.println("\n\nCopi/digite o texto cripografado acima...");
        System.out.println("Digite : ");
        texto = recebe.nextLine();
        
        System.out.println("\nTexto Cripografado : " + texto);
        System.out.println("Texto Descriptografado : " + cd.DecodificaTexto(texto));
    }
    
}
