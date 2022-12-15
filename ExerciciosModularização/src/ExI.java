import java.util.Scanner;

public class ExI {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        if (fibonacci(ler.nextInt())) {
            System.out.println("e de Fibonacci");
        } else {
            System.out.println("nao e de Fibonacci");
        }
    }

    public static boolean fibonacci(int num) {
        int termo0 = 0, termo1 = 1; //na sequencia de fibonacci o primeiro termo é 0 e o segundo termo é 1
        int termoNovo = 0;
        while (termoNovo <= num) {
            if ( num == termoNovo || num == termo1 ){
                return true;
            }
            termoNovo = termo0 + termo1;
            termo0 = termo1;
            termo1 = termoNovo;
        }
        return false;
    }

}
