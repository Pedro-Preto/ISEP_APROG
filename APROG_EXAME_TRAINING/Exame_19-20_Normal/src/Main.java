import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Main {


    //Scanners in and out
    private static final Scanner in = new Scanner(System.in);
    private static final Formatter out = new Formatter(System.out);


    private static final int MAXIMO_LINHAS_FILAS = 24;
    private static final int MAXIMO_COLUNAS_COLUNAS = 31;
    private static final String FICHEIRO = "ocupacao.txt";


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcao;
        int[][] sala = new int[MAXIMO_LINHAS_FILAS][MAXIMO_COLUNAS_COLUNAS];
        int n;
        do {
            System.out.println();
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println();
            out.format("1 - Ler  ficheiro\n");
            out.format("2 -Calcular Bilheteira\n");
            out.format("3 -Lugares reservados \n");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    lerOcupacaoDaSala(FICHEIRO, sala);
                    out.format("Ficheiro lido\n");
                    break;
                case 2:
                    calcularBilheteira(sala);
                    break;
                case 3:
                    out.format("Insira o número de bilhetes\n");
                    n = in.nextInt();
                    informarLugares(sala, n);
                    break;
                case 0:
                    break;
                default:
                    out.format("Opção não é válida\n");
                    break;
            }
        } while (opcao != 0);
    }


    public static int[][] lerOcupacaoDaSala(String nomeFicheiro, int[][] sala) {
        int contadorDeLinhas = 0;


        try (Scanner sc = new Scanner(new FileReader(nomeFicheiro))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    String[] auxiliarDados = linha.split(";");
                    if (auxiliarDados.length == MAXIMO_COLUNAS_COLUNAS) {
                        inserirRegisto(sala, contadorDeLinhas, auxiliarDados);
                        contadorDeLinhas++;
                    }
                }

            }
            for (int[] s : sala) {
                out.format(Arrays.toString(s) + "\n");
            }
            return sala;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void inserirRegisto(int[][] sala, int contadorDeLinhas, String[] auxiliarDados) {

        for (int i = 0; i < MAXIMO_COLUNAS_COLUNAS; i++)
            sala[contadorDeLinhas][i] = Integer.parseInt(auxiliarDados[i]);

    }

    private static int calcularBilheteira(int[][] sala) {
        int lugar;
        int valorProximo = 0;
        int valorMedio = 0;
        int valorAfastado = 0;
        for (int n = 0; n < MAXIMO_LINHAS_FILAS; n++) {
            for (int j = 1; j < MAXIMO_COLUNAS_COLUNAS; j++) {
                lugar = sala[n][j];
                if (lugar == 1) {
                    if (n <= 7) {
                        int custo = 20;
                        valorProximo += custo;
                    } else if (n >= 8 && n <= 15) {
                        int custo = 15;
                        valorMedio += custo;
                    } else if (n >= 16 && n <= 24) {
                        int custo = 10;
                        valorAfastado += custo;


                    }
                }
            }
        }
        int valorTotal = valorAfastado + valorProximo + valorMedio;
        System.out.println("O valor total é" + " " + valorTotal + " " + "€" + ".");
        return valorTotal;

    }

    public static int informarLugares(int[][] sala, int nBilhetes) {
        int count = 0, lugar, fila = 0;
        boolean flag = false;
        if (nBilhetes <= 30) {
            if (flag == false) {
                for (int n = MAXIMO_LINHAS_FILAS - 1; n >= 0; n--) {
                    if (flag == true)
                        break;
                    for (int j = 1; j < MAXIMO_COLUNAS_COLUNAS; j++) {
                        if (flag == true)
                            break;

                        lugar = sala[n][j];

                        if (lugar == 0) {
                            count++;
                            if (count == nBilhetes) {
                                fila = sala[n][0];
                                flag = true;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (fila == 0)
                fila = -1;
            System.out.println("Fila nº" + " " + fila + ".");
        } else {
            out.format("Valor não válido");
        }

        return fila;
    }
}

