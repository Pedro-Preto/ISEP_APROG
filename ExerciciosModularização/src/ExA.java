import java.util.Scanner;
public class ExA {
    
    public static String invertString(String str) {
        String result = "";
        while (str.length()!=0) {
        result = str.charAt(0) + result;
        str = str.substring(1);
        }
        return result;
    }
    
    //===========================================================
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String nome, nomeInvertido;
        boolean aux = true;
        int n = 0;
        while(aux){
            nome=read.nextLine();
            nomeInvertido = invertString(nome);
            if(nome.equalsIgnoreCase(nomeInvertido)){
            aux=false;
            } 
            n = n+1;
        }
        System.out.println(n-1);  
    } 
}
