
import java.util.Scanner;

public class ExH {

    public static int[] arrayFactory(int range, Scanner s) {
        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static int[] rotation(int[] arr, String direction) {
        int[] temp = new int[arr.length];
        if (direction.equals("esquerda")) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    temp[arr.length - 1] = arr[0];
                } else {
                    temp[i - 1] = arr[i];
                }
            }
            return temp;
        }
        if (direction.equals("direita")) {
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    temp[0] = arr[arr.length - 1];
                } else {
                    temp[i + 1] = arr[i];
                }
            }
            return temp;
        }
        return arr;
    }

    public static void arrayPrinter(int[] arr) {
        for (int i : arr) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        if (len != 0) {
            int[] sequence = arrayFactory(len, s);
            String direction = s.next();
            while (!direction.equals("sair")) {
                if (direction.equals("esquerda") || direction.equals("direita")) {
                    sequence = rotation(sequence, direction);
                    arrayPrinter(sequence);

                }
                direction = s.next();
            }
        }
    }
}
