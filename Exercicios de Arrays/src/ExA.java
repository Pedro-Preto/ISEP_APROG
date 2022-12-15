
import java.util.Scanner;


public class ExA {

    static Scanner input = new Scanner(System.in);

    public static double rounder(double n, int order) {
        int temp = (int) (n * Math.pow(10, order + 1));
        if (temp % 10 >= 5) {
            temp += 1;
        }
        return (temp / Math.pow(10.0, order + 1));

    }

    public static double[] arrayAdder(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextDouble();
        }
        return arr;
    }

    public static double media(double[] arr) {
        double sum = 0;
        for (double i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }

    public static int reprovados(double[] arr) {
        int count = 0;
        for (double i : arr) {
            if (i < 10) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int rep = input.nextInt();
        double[] notas = arrayAdder(rep);
        System.out.println("media=" + rounder(media(notas), 1));
        System.out.println("reprovacoes=" + reprovados(notas));

    }

}
