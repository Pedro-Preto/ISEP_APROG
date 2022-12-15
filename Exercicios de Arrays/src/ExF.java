
import java.util.Scanner;
import java.text.DecimalFormat;

public class ExF {

    static Scanner input = new Scanner(System.in);
    static DecimalFormat formatter = new DecimalFormat("0.00");

    public static void main(String[] args) {
        int meses = 6;
        double ord;
        double[] juros = new double[meses];
        for (int i = 0; i < meses; i++) {
            juros[i] = input.nextDouble() + 1;
        }
        ord = input.nextDouble();
        for (int i = 0; i < meses; i++) {
            ord = ord * juros[i];
        }
        System.out.println("valor final=" + formatter.format(ord));
    }

}
    

