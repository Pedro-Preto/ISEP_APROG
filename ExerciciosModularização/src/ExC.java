
import java.util.Scanner;

public class ExC {

    public static void main(String[] args) {
        int lado1, lado2, lado3;
        Scanner sc = new Scanner(System.in);
        lado1 = sc.nextInt();
        lado2 = sc.nextInt();
        lado3 = sc.nextInt();
        boolean valido = verSeEValido(lado1, lado2, lado3);
        if (valido == true) {
            System.out.println("a=" + lado1);
            System.out.println("b=" + lado2);
            System.out.println("c=" + lado3);
            System.out.println("ang(a,b)=" + calcAng(lado1, lado2, lado3));

            System.out.println("ang(a,c)=" + calcAng(lado1, lado3, lado2));
            System.out.println("ang(b,c)=" + calcAng(lado3, lado2, lado1));
        } else {
            System.out.println("impossivel");
        }
    }
    //////////////////////////////////////////////////////////////////// 

    public static int calcAng(float lado1, float lado2, float lado3) {
        return (int) Math.toDegrees(Math.acos(((lado1 * lado1) + (lado2 * lado2) - (lado3 * lado3)) / (2 * lado1 * lado2)));

    }

    private static boolean verSeEValido(float lado1, float lado2, float lado3) {
        if (lado1 > 0 && lado2 > 0 && lado3 > 0 && lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
            return true;
        }
        return false;
    }
}
