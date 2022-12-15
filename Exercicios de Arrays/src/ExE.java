
import java.util.Scanner;

public class ExE {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int a = 0, nPessoas = 0, i = 0, b = 0;
        double soma = 0;
        String[] array1;
        array1 = new String[20];
        double[] array2;
        array2 = new double[20];
        String nome = new String();
        nome = ler.next();
        while (!nome.equals("fim")) {
            array1[a] = nome;
            array2[a] = ler.nextDouble();
            soma += array2[a];
            nome = ler.next();
            nPessoas++;
            a++;
        }
        System.out.println(Media(soma, nPessoas));
        for (b = 0; b < array2.length; b++) {
            if (array2[b] != 0) {
                if (array2[b] < Media(soma, nPessoas)) {
                    System.out.println(array1[b]);
                }
            }
        }

    }

    public static double Media(double soma, int nPessoas) {
        double media = soma / nPessoas;
        return media;
    }

}
