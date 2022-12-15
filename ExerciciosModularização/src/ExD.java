
import java.util.Scanner;

public class ExD {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int m = ler.nextInt(), n = ler.nextInt();
        if (m >= 0 && n >= 0) {
            if (m >= n) {
                combinacoes(m, n);
                permutacoes(m, n);
            }
        }
    }

    public static int fatorial(int a) {
        int fatorial = 1;
        for (int i = 1; i <= a; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public static void combinacoes(int m, int n) {
        int combinacoes;
        combinacoes = fatorial(m) / (fatorial(n) * fatorial(m - n));
        System.out.println("C(" + m + "," + n + ")=" + combinacoes);
    }

    public static void permutacoes(int m, int n) {
        int permutacoes;
        permutacoes = fatorial(m) / fatorial(m - n);
        System.out.println("P(" + m + "," + n + ")=" + permutacoes);
    }
}
