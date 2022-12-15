/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

/**
 * @author pedro
 */
public class APROG_EXAME_TREINO {

    private static final String FICHEIRO = "Registo.txt";
    private static final int MAXIMO_LINHAS = 7;
    private static final int MAXIMO_COLUNAS = 24;

    //Scanners in and out
    private static Scanner in = new Scanner(System.in);
    private static Formatter out = new Formatter(System.out);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        int opcao;
        int n = 0;
        Double[][] temperaturas = new Double[MAXIMO_LINHAS][MAXIMO_COLUNAS];
        do {
            System.out.println();
            out.format("1 - Ler  ficheiro\n");
            out.format("2 - Nº de vezes que o ar condicionado foi ligado \n");
            out.format("3 - Sugestão para ligar o ar condicionado\n");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    lerFicheiro(FICHEIRO, temperaturas);
                    out.format("Ficheiro lido\n");
                    break;
                case 2:
                    out.format("Selecione o dia\n");
                    ligacoesDoEquipamentoDoDia(temperaturas);
                    break;
                case 3:
                    sugestaoParaLigarAquecimetoAsHoras(temperaturas);
                    break;
                case 0:
                    break;
                default:
                    out.format("Opção não é válida\n");
                    break;
            }
        } while (opcao != 0);
    }

    private static int lerFicheiro(String nameFile, Double[][] temperaturas) throws FileNotFoundException {
        int contadorDeLinhas = 0;
        try (Scanner sc = new Scanner(new FileReader(nameFile))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    String auxiliarDados[] = linha.split(" ");
                    if (auxiliarDados.length == MAXIMO_COLUNAS) {
                        inserirRegisto(temperaturas, contadorDeLinhas, auxiliarDados);
                        contadorDeLinhas++;
                    }
                }

            }
        }
        for (Double[] g : temperaturas) {
            System.out.println(Arrays.toString(g) + "\n");
        }
        return contadorDeLinhas;
    }

    private static void inserirRegisto(Double[][] temperaturas, int contadorDeLinhas, String[] auxiliarDados) {
        for (int i = 0; i < MAXIMO_COLUNAS; i++) {

            temperaturas[contadorDeLinhas][i] = Double.parseDouble(auxiliarDados[i]);
        }
    }

    private static int ligacoesDoEquipamentoDoDia(Double[][] temperaturas) {
        int count = 0;
        int n = in.nextInt();
        n -= 1;
        if (n >= 0 && n < 7) {

            for (int j = 8; j < 18; j++) {
                if (temperaturas[n][j] < 10 && temperaturas[n][j] != null) {
                    count++;
                } else if (temperaturas[n][j] > 20) {
                    count += 0;
                } else if (10 <= temperaturas[n][j] && temperaturas[n][j] <= 20) {
                    count += 0;
                }

            }
            out.format("Foi ligado %s vezes", count);

        } else {
            out.format("Insira um numero igual ou menor que 0 e menor que 7");
        }

        return count;
    }

    private static String[] sugestaoParaLigarAquecimetoAsHoras(Double[][] temperaturas) {
        String[] sugestao = new String[MAXIMO_COLUNAS];
        out.format("Insira o dia\n");
        int n = in.nextInt();
        int day = n - 1;
        if (day >= 0 && day < 7) {
            for (int j = 0; j < MAXIMO_COLUNAS; j++) {
                if (temperaturas[day][j] < 10) {
                    sugestao[j] = "T";
                } else {
                    sugestao[j] = "F";

                }
            }
            System.out.println(Arrays.toString(sugestao));

        } else {
            out.format("Insira um numero igual ou menor que 0 e menor que 7");
        }

        return sugestao;

    }

}
