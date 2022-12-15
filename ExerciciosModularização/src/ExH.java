import java.util.Scanner;

public class ExH {

    static Scanner ler = new Scanner(System.in);
    static final int TENTATIVAS = 5;

    public static void main(String[] args) {
        int num;
        for (int i = 0; i <= TENTATIVAS; i++) {
            if (i == TENTATIVAS) {
                System.out.println("tentativas excedidas");
                break;
            } else {
                if ((num = ler.nextInt()) > 10) {
                    if (capicua(num)) {
                        System.out.println("capicua");
                        break;
                    }
                }

            }

        }
    }

    public static boolean capicua(int num) {
        int dig, numInvertido = 0, aux, ordem = 0;
        aux = num;
        while (aux > 0) {
            dig = aux % 10;
            numInvertido = numInvertido * 10 + dig;
            aux /= 10;
        }
        return num == numInvertido;
    }

}