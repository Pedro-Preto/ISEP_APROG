import java.util.Scanner;
public class ExK {
    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args){
        String frase = ler.nextLine();
        char cAntes = ler.next().charAt(0); ler.nextLine();
        char cDepois = ler.next().charAt(0); ler.nextLine();
        System.out.println(substituidorCaracteres(frase,cAntes,cDepois));

    }
    public static String substituidorCaracteres(String frase, char cAntes, char cDepois){
        String fraseResultante = "";
        for (int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == cAntes){
               fraseResultante += cDepois;
            } else {
            fraseResultante += frase.charAt(i);
            }
        }
        return fraseResultante;
    }
}
