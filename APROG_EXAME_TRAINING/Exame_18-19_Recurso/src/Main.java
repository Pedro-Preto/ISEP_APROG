import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Formatter out = new Formatter(System.out);

    private static final String FICHEIRO = "apostas.txt";
    private static final int MAX_APOSTAS = 5;
    private static final int N_NUMEROS = 5;
    private static final int N_ESTRELAS = 2;
    private static final int MAX_COLUNAS = N_ESTRELAS + N_NUMEROS;

    public static void main(String[] args) {
        int opcao;

        int[][] apostas = new int[MAX_APOSTAS][MAX_COLUNAS];
        int[] aposta = new int[MAX_COLUNAS];
        int contadorDeLinhas = 0;
        int n = 0;
        do {
            System.out.println();
            out.format("1 - \n");
            out.format("2 - \n");
            out.format("3 - \n");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    mostrarApostas(apostas, n);
                    break;
                case 2:
                    ordenarAposta(aposta, apostas);
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    out.format("Opção não é válida\n");
                    break;
            }
        } while (opcao != 0);
    }

    private static void mostrarApostas(int[][] apostas, int nApostas) {

        int contadorDeLinhas = 0;


        try (Scanner sc = new Scanner(new FileReader(FICHEIRO))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    String[] auxiliarDados1 = linha.split(" ");

                    if (auxiliarDados1.length == MAX_COLUNAS) {

                        inserirNumeros(apostas, contadorDeLinhas, auxiliarDados1);
                        contadorDeLinhas++;

                    }
                }

            }
            nApostas = contadorDeLinhas;

            for (int[] s : apostas) {
                out.format(Arrays.toString(s) + "\n");

            }
            System.out.println(String.format("O numero de apostas é de %s\n", nApostas));

        } catch (FileNotFoundException e) {
            e.getMessage();
        }

    }


    private static void inserirNumeros(int[][] apostas, int contadorDeLinhas, String[] auxiliarDados1) {
        for (int i = 0; i < MAX_COLUNAS; i++) {

            apostas[contadorDeLinhas][i] = Integer.parseInt(auxiliarDados1[i]);
        }

    }

    private static void ordenarAposta(int[] aposta, int[][] apostas) {

        for (int i = 0; i < MAX_APOSTAS; i++) {
            for (int j = 0; j < MAX_COLUNAS; j++) {
                for (int k = 0; k < MAX_COLUNAS; k++) {
                    aposta[k] = apostas[i][j];
                    //Arrays.stream(aposta).sorted();
                }
            }
        }
        for (int s : aposta) {
            out.format(s + "\n");

        }

    }


}
