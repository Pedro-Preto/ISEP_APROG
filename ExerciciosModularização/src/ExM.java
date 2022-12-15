import java.util.Scanner;

public class ExM {
    static Scanner ler = new Scanner(System.in);
    static final int VALORPOSITIVO = 10;
    static final int VALORNEGATIVO = -10;
    public static void main(String[] args){
        String frase = ler.nextLine();
        System.out.println(converterParaMaiusculasOuMinisculas(frase,VALORPOSITIVO));
        System.out.println(converterParaMaiusculasOuMinisculas(frase,VALORNEGATIVO));
    }
    public static String converterParaMaiusculasOuMinisculas(String frase, int valor){
      if (valor > 0)
          return frase.toUpperCase();
       else if (valor < 0)
          return frase.toLowerCase();
       else 
          return frase;
      }
}
