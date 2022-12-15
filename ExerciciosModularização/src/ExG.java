

import java.util.Scanner;

public class ExG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean a;

        for (int i = 0; i <= N; i++) {
            a = verificarNumero(i);

            if (a) {
                System.out.println(i);
            }

        }
    }

    public static boolean verificarNumero(int num) {
        int r, num1;
        double digitos = 0, soma = 0, num2;

        num1 = num;
        num2 = num1;

        //Numero de algarismos
        do {
            digitos++;
            num = num / 10;
        } while (num != 0);

        //Soma dos algarismos (cada um elevado ao numero de algarismos total)
        do {
            r = num1 % 10;
            soma = soma + Math.pow(r, digitos);
            num1 = num1 / 10;
        } while (num1 != 0);

        return soma == num2;
    }
}