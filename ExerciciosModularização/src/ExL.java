import java.util.Scanner;
public class ExL {
    static Scanner ler = new Scanner(System.in);
    
    public static void main(String[] args){
        String frase = ler.nextLine();
        System.out.println(contaPalavras(frase));
    }
    
    public static int contaPalavras(String frase){
        int contador = 0;
        char cAnterior = frase.charAt(0), c;
        
        for (int i = 0; i < frase.length(); i++){
            c = frase.charAt(i);
            if (c != ' ' && cAnterior == ' '){
                contador++;
            }
            cAnterior = c;
        }
        return contador;
    }
}
