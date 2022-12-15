/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exame_normal_2018;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

/**
 * @author pedro
 */
public class Exame_Normal_2018 {
    //Scanners in and out

    private static Scanner in = new Scanner(System.in);
    private static Formatter out = new Formatter(System.out);

    private static final String FICHEIRO = "ficheiro.txt";

    private static final int MAXIMO_COLUNAS = 4;
    private static final int MAXIMO_LINHAS = 5;

    private static final int COLUNA_ALIMENTO = 0;
    private static final int COLUNA_DOSE = 1;
    private static final int COLUNA_QUANTIDADE = 2;
    private static final int COLUNA_CALORIAS = 3;

    //  private static final int MAXIMO_Equipas=;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        int opcao;
        String[][] dados = new String[MAXIMO_LINHAS][MAXIMO_COLUNAS];
        int contadorDeLinhas = 0;

        do {
            System.out.println();
            out.format("1 - Quantidade de alimentos\n");
            out.format("2 - Ler Ficheiro \n");
            out.format("3 - Gravar refeição\n");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    obterQuantidadeDeAlimentos();
                    break;
                case 2:
                    lerTabelaDeAlimentos(dados);
                    break;
                case 3:
                    gravarRefeicao(dados, contadorDeLinhas);
                    break;
                case 0:
                    break;
                default:
                    out.format("Opção não é válida\n");
                    break;
            }
        } while (opcao != 0);
    }

    /* Lê os nomes das equipas existentes no ficheiro nomeFicheiro e retorna um
    array completamente preenchido com os nomes dessas equipas.
     */
    private static int obterQuantidadeDeAlimentos() throws FileNotFoundException {

        int contadorDeLinhas = 0;
        try (Scanner sc = new Scanner(new FileReader(FICHEIRO))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    String auxiliarDados[] = linha.split(";");
                    if (auxiliarDados.length == MAXIMO_COLUNAS) {
                        contadorDeLinhas++;
                    }
                }

            }
        }
        out.format("-- -- -- -- -- -- -- -- -- -- -- --\n");
        out.format("Existem %s alimentos\n", contadorDeLinhas);
        out.format("-- -- -- -- -- -- -- -- -- -- -- --\n");
        return contadorDeLinhas;

    }

    private static int lerTabelaDeAlimentos(String[][] dados) throws FileNotFoundException {

        int contadorDeLinhas = 0;
        try (Scanner sc = new Scanner(new FileReader(FICHEIRO))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    String auxiliarDados[] = linha.split(";");
                    if (auxiliarDados.length == MAXIMO_COLUNAS) {
                        inserirDados(dados, contadorDeLinhas, auxiliarDados);
                        contadorDeLinhas++;
                    }
                }

            }
        }
        for (String[] g : dados) {
            System.out.println(Arrays.toString(g));
        }
        return contadorDeLinhas;
    }

    private static void inserirDados(String[][] dados, int contadorDeLinhas, String[] auxiliarDados) {
        for (int i = 0; i < MAXIMO_COLUNAS; i++) {
            dados[contadorDeLinhas][i] = auxiliarDados[i];

        }
    }
        private static void gravarRefeicao (String[][]dados,int contadorDeLinhas){
            int max = 0;
            Formatter outFile;
            try {
                outFile = new Formatter("Refeição.csv");
                for (int i = 0; i < contadorDeLinhas; i++) {
                    max += Integer.parseInt(dados[i][COLUNA_CALORIAS]);
                    outFile.format("%s,%d,Total calorias=%d\n", Integer.parseInt(dados[i][COLUNA_ALIMENTO]),
                            dados[i][COLUNA_CALORIAS], max);
                }
                outFile.close();
                out.format("O Ficheiro foi gravado com sucesso!\n");
            } catch (FileNotFoundException ex) {
                out.format("Ocorreu um erro ao gravar para o ficheiro!\n");
            }
        }

    }
