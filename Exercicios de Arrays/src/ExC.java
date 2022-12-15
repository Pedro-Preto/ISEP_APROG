
import java.util.Scanner;

public class ExC {

    static Scanner input = new Scanner(System.in);

    public static boolean higher(int a, int b) {
        return a > b;
    }

    public static boolean controler(int[] arr) {
        int teste = -1;
        for (int i : arr) {
            if (!higher(i, teste)) {
                return false;
            }
            teste = i;
        }
        return true;
    }

    public static int[] arrayFactory(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sequencia = arrayFactory(input.nextInt());
        if (controler(sequencia)) {
            System.out.println("sempre crescente = true");
        } else {
            System.out.println("sempre crescente = false");
        }
    }

}
