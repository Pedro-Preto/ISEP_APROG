import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class APP {

    private static final int MAXIMO_LINHAS = 32;
    private static final int MAXIMO_COLUNAS = 8;

    // equipas
    private static final int COLUNA_GRUPO = 0;
    private static final int COLUNA_EQUIPA = 1;

    // resultados
    private static final int COLUNA_JOGOS = 0;
    private static final int COLUNA_VITORIAS = 1;
    private static final int COLUNA_EMPATES = 2;
    private static final int COLUNA_DERROTAS = 3;
    private static final int COLUNA_GOLOS_MARCADOS = 4;
    private static final int COLUNA_GOLOS_SOFRIDOS = 5;
    private static final int COLUNA_PONTUACAO = 6;

    // classificacao
    private static final int COLUNA_CLASSIFICACAO_GRUPO = 0;
    private static final int COLUNA_CLASSIFICACAO_EQUIPA = 1;

    // grupos
    private static final int MAXIMO_EQUIPAS_GRUPO = 4;

    private static final String FICHEIRO = "PracticalWork.csv";

    //Scanners in and out
    private static Scanner in = new Scanner(System.in);
    private static Formatter out = new Formatter(System.out);

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Variaveis necessárias para os dados
        String[][] equipas = new String[MAXIMO_LINHAS][2];
        int[][] resultados = new int[MAXIMO_LINHAS][7];
        String[][] classificacao = new String[MAXIMO_LINHAS][2];
        String[][] equipasAux = new String[MAXIMO_LINHAS][2];
        int[][] resultadosAux = new int[MAXIMO_LINHAS][7];
        String[][] classificacaoAux = new String[MAXIMO_LINHAS][2];

        int contadorDeEquipas = 0, cont_classificacao = 0;
        int listar_classificacao = 0;
        int novoContador = 0;
        int opcao;

        // ler o conteudo do ficheiro e carregar s valores par dentro dos arrays
        contadorDeEquipas = lerFicheiro(equipas, resultados);
        // Os arrays irão estar sempre ordenados por grupo
        ordenarEquipasPorGrupos(equipas, resultados, contadorDeEquipas);
        if (contadorDeEquipas != 0) {
            // menu para o utilizador executar açoes
            System.out.println("O ficheiro a ser lido, caso não utilize a opcao 1, é o ficheiro default!");
            do {
                System.out.println();
                System.out.println();
                out.format("1 - Ler novo ficheiro\n");
                out.format("2 - Inserir novo registo\n");
                out.format("3 - Calcular a pontuação das Equipas\n");
                out.format("4 - Calcular a classificação das Equipas\n");
                out.format("5 - Listar classificação por Grupo\n");
                out.format("6 - Listar as equipas cujos golos marcados é igual ao máximo de golos marcados\n");
                out.format("7 - Listar as equipas com um determinado número de golos sofridos\n");
                out.format("8 - Listar as equipas que têm mais golos sofridos do que golos marcados\n");
                out.format("9 - Listar o primeiro classificado de cada grupo\n");
                out.format("10 - Listar a informacao completa de uma equipa\n");
                out.format("11 - Criar um ficheiro de texto (Statistics.txt) com estatísticas dos jogos \n");
                out.format("12 - Apagar As equipas que não vão passar\n");
                out.format("13 - Criar um ficheiro de texto (FinalStage.csv) com as equipas que vão disputar a fase seguinte \n");
                out.format("14 - Criar um ficheiro de texto com os jogos da fase final \n");
                out.format("0 - SAIR\n");
                opcao = in.nextInt();
                switch (opcao) {
                    case 1:
                        contadorDeEquipas = lerNovoFicheiro(equipas, resultados);
                        ordenarEquipasPorGrupos(equipas, resultados, contadorDeEquipas);
                        out.format("Ficheiro lido e informação guardada");
                        break;
                    case 2:
                        ordenarEquipasPorGrupos(equipas, resultados, contadorDeEquipas);
                        contadorDeEquipas = inserirNovoRegisto(equipas, resultados, contadorDeEquipas);
                        ordenarEquipasPorGrupos(equipas, resultados, contadorDeEquipas);
                        break;
                    case 3:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        out.format("Pontuação calculada");
                        break;
                    case 4:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        out.format("Classificação calculada");
                        break;
                    case 5:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        listarClassificacao(classificacao, equipas, resultados, contadorDeEquipas);
                        break;
                    case 6:
                        listarEquipasComMaximoGolosMarcados(equipas, resultados, contadorDeEquipas);
                        break;
                    case 7:
                        listarEquipasComNGolosSofridos(equipas, resultados, contadorDeEquipas);
                        break;
                    case 8:
                        listarEquipasComMaisGoloSofridosDoQueMarcados(equipas, resultados, contadorDeEquipas);
                        break;
                    case 9:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        listarPrimeiroClassificadoDeCadaGrupo(classificacao, equipas, resultados, contadorDeEquipas);
                        break;
                    case 10:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        listarInformacaoEquipa(equipas, resultados, contadorDeEquipas, classificacao);
                        break;
                    case 11:
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        escreverlistarInformacaoJogos(equipas, resultados, classificacao, contadorDeEquipas);
                        break;
                    case 12:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        contadorDeEquipas = apagaEquipasQueNaoPassam(equipas, resultados, contadorDeEquipas, classificacao);
                        out.format("Equipas que não vão disputar a próxima fase removidas.");
                        break;
                    case 13:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        novoContador = equipasQuePassamAuxiliar(equipas, resultados, contadorDeEquipas, classificacao,
                                equipasAux, resultadosAux, classificacaoAux);
                        escreverEquipasFaseFinal(equipasAux, resultadosAux, classificacaoAux, novoContador);
                        break;
                    case 14:
                        calcularPontuacao(equipas, resultados, contadorDeEquipas);
                        calcularClassificacao(equipas, resultados, contadorDeEquipas, classificacao);
                        novoContador = equipasQuePassamAuxiliar(equipas, resultados, contadorDeEquipas, classificacao,
                                equipasAux, resultadosAux, classificacaoAux);
                        listarJogosFinais(equipasAux, resultadosAux, classificacaoAux, novoContador);
                        break;
                    case 0:
                        break;
                    default:
                        out.format("Opção não é válida\n");
                        break;
                }
            } while (opcao != 0);
        }
    }

    private static void listarJogosFinais(String[][] equipas, int[][] resultados, String[][] classificacao,
            int contadorDeEquipas) {

        int contGrupos = 0, pos, idx;
        int idx1, idx2, idx3, idx4;
        String grupoAtual = "";
        try {
            pos = 0;
            for (int i = 0; i < contadorDeEquipas; i++) {
                idx = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]);
                if (!grupoAtual.equalsIgnoreCase(classificacao[i][COLUNA_CLASSIFICACAO_GRUPO])) {
                    if (!grupoAtual.isEmpty() && pos != 2) {
                        throw new Exception("O número máximo de equipas que passam por grupo tem de ser igual a dois!");
                    }
                    pos = 0;
                    contGrupos++;
                    grupoAtual = classificacao[i][COLUNA_CLASSIFICACAO_GRUPO];
                }
                pos++;
            }
            if (pos != 2) {
                throw new Exception("O número máximo de equipas que passam por grupo tem de ser igual a dois!");
            }
            if (contGrupos % 2 != 0) {
                throw new Exception("O número total de Grupos tem de ser par!");
            }
            Formatter outFile = new Formatter("FinalStageGames.txt");
            // 0 vs 3
            // 1 vs 2
            for (int i = 0; i < contadorDeEquipas; i += 4) {
                idx1 = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]); // 0
                idx2 = Integer.parseInt(classificacao[i + 1][COLUNA_CLASSIFICACAO_EQUIPA]); // 1
                idx3 = Integer.parseInt(classificacao[i + 2][COLUNA_CLASSIFICACAO_EQUIPA]); // 2
                idx4 = Integer.parseInt(classificacao[i + 3][COLUNA_CLASSIFICACAO_EQUIPA]); // 3
                outFile.format("%s,%d,%s - %s,%d,%s\n", equipas[idx1][COLUNA_GRUPO], 1, equipas[idx1][COLUNA_EQUIPA],
                        equipas[idx4][COLUNA_GRUPO], 2, equipas[idx4][COLUNA_EQUIPA]);
                outFile.format("%s,%d,%s - %s,%d,%s\n", equipas[idx2][COLUNA_GRUPO], 2, equipas[idx2][COLUNA_EQUIPA],
                        equipas[idx3][COLUNA_GRUPO], 1, equipas[idx3][COLUNA_EQUIPA]);
            }
            outFile.close();
            out.format("O ficheiro foi gerado com sucesso");
        } catch (Exception e) {
            out.format(e.getMessage());
        }
    }

    private static int equipasQuePassamAuxiliar(String[][] equipas, int[][] resultados, int contador,
            String[][] classificacao, String[][] equipasAux, int[][] resultadosAux, String[][] classificacaoAux) {

        int pos = -1;
        int novoContador = 0;
        String grupoAtual = "";
        for (int i = 0; i < contador; i++) {
            int idxEquipa = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]);
            if (!grupoAtual.equalsIgnoreCase(equipas[idxEquipa][COLUNA_GRUPO])) {
                pos = 1;
                grupoAtual = equipas[idxEquipa][COLUNA_GRUPO];
            }
            if (pos == 1 || pos == 2) {
                equipasAux[novoContador][COLUNA_GRUPO] = equipas[idxEquipa][COLUNA_GRUPO];
                equipasAux[novoContador][COLUNA_EQUIPA] = equipas[idxEquipa][COLUNA_EQUIPA];
                resultadosAux[novoContador][COLUNA_JOGOS] = resultados[idxEquipa][COLUNA_JOGOS];
                resultadosAux[novoContador][COLUNA_VITORIAS] = resultados[idxEquipa][COLUNA_VITORIAS];
                resultadosAux[novoContador][COLUNA_EMPATES] = resultados[idxEquipa][COLUNA_EMPATES];
                resultadosAux[novoContador][COLUNA_DERROTAS] = resultados[idxEquipa][COLUNA_DERROTAS];
                resultadosAux[novoContador][COLUNA_GOLOS_MARCADOS] = resultados[idxEquipa][COLUNA_GOLOS_MARCADOS];
                resultadosAux[novoContador][COLUNA_GOLOS_SOFRIDOS] = resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS];
                resultadosAux[novoContador][COLUNA_PONTUACAO] = resultados[idxEquipa][COLUNA_PONTUACAO];
                classificacaoAux[novoContador][COLUNA_CLASSIFICACAO_GRUPO] = equipas[idxEquipa][COLUNA_GRUPO];
                classificacaoAux[novoContador][COLUNA_CLASSIFICACAO_EQUIPA] = Integer.toString(novoContador);
                novoContador++;
            }
            pos++;
        }
        return novoContador;
    }

    private static int apagaEquipasQueNaoPassam(String[][] equipas, int[][] resultados, int contador,
            String[][] classificacao) {

        String[][] equipasAux = new String[MAXIMO_LINHAS][2];
        int[][] resultadosAux = new int[MAXIMO_LINHAS][7];
        String[][] classificacaoAux = new String[MAXIMO_LINHAS][2];
        int pos = -1;
        int novoContador = 0;
        String grupoAtual = "";
        for (int i = 0; i < contador; i++) {
            int idxEquipa = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]);
            if (!grupoAtual.equalsIgnoreCase(equipas[idxEquipa][COLUNA_GRUPO])) {
                pos = 1;
                grupoAtual = equipas[idxEquipa][COLUNA_GRUPO];
            }
            if (pos == 1 || pos == 2) {
                equipasAux[novoContador][COLUNA_GRUPO] = equipas[idxEquipa][COLUNA_GRUPO];
                equipasAux[novoContador][COLUNA_EQUIPA] = equipas[idxEquipa][COLUNA_EQUIPA];
                resultadosAux[novoContador][COLUNA_JOGOS] = resultados[idxEquipa][COLUNA_JOGOS];
                resultadosAux[novoContador][COLUNA_VITORIAS] = resultados[idxEquipa][COLUNA_VITORIAS];
                resultadosAux[novoContador][COLUNA_EMPATES] = resultados[idxEquipa][COLUNA_EMPATES];
                resultadosAux[novoContador][COLUNA_DERROTAS] = resultados[idxEquipa][COLUNA_DERROTAS];
                resultadosAux[novoContador][COLUNA_GOLOS_MARCADOS] = resultados[idxEquipa][COLUNA_GOLOS_MARCADOS];
                resultadosAux[novoContador][COLUNA_GOLOS_SOFRIDOS] = resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS];
                resultadosAux[novoContador][COLUNA_PONTUACAO] = resultados[idxEquipa][COLUNA_PONTUACAO];
                classificacaoAux[novoContador][COLUNA_CLASSIFICACAO_GRUPO] = equipas[idxEquipa][COLUNA_GRUPO];
                classificacaoAux[novoContador][COLUNA_CLASSIFICACAO_EQUIPA] = Integer.toString(novoContador);
                novoContador++;
            }
            pos++;
        }
        System.arraycopy(equipasAux, 0, equipas, 0, novoContador);
        System.arraycopy(resultadosAux, 0, resultados, 0, novoContador);
        System.arraycopy(classificacaoAux, 0, classificacao, 0, novoContador);
        return novoContador;
    }

    private static void listarInformacaoEquipa(String[][] equipas, int[][] resultados, int contador,
            String[][] classificacao) {

        int verificacao = 0;
        String nomeEquipa = "";
        out.format("Insira a equipa a listar:");
        do {
            nomeEquipa = in.nextLine();
        } while (nomeEquipa.equalsIgnoreCase(""));
        for (int j = 0; j < contador; j++) {
            if (classificacao[j][COLUNA_CLASSIFICACAO_GRUPO] != null) {
                if (equipas[j][COLUNA_EQUIPA].equalsIgnoreCase(nomeEquipa)) {
                    verificacao = verificacao + 1;
                }
            }
        }
        if (verificacao != 1) {
            out.format("Equipa não encontrada!");
        } else {
            out.format("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD |\n");
            out.format("|=====|=====|=================|====|====|====|====|====|====|====|====|\n");
            int pos = -1;
            String grupoAtual = "";
            for (int i = 0; i < contador; i++) {
                int idxEquipa = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]);
                if (classificacao[idxEquipa][COLUNA_CLASSIFICACAO_GRUPO] != null) {
                    if (!grupoAtual.equalsIgnoreCase(equipas[idxEquipa][COLUNA_GRUPO])) {
                        pos = 1;
                        grupoAtual = equipas[idxEquipa][COLUNA_GRUPO];
                    }
                }
                if (nomeEquipa.equalsIgnoreCase(equipas[idxEquipa][COLUNA_EQUIPA])) {
                    out.format("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", equipas[idxEquipa][COLUNA_GRUPO],
                            pos, equipas[idxEquipa][COLUNA_EQUIPA], resultados[idxEquipa][COLUNA_PONTUACAO],
                            resultados[idxEquipa][COLUNA_JOGOS], resultados[idxEquipa][COLUNA_VITORIAS],
                            resultados[idxEquipa][COLUNA_EMPATES], resultados[idxEquipa][COLUNA_DERROTAS],
                            resultados[idxEquipa][COLUNA_GOLOS_MARCADOS], resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS],
                            resultados[idxEquipa][COLUNA_GOLOS_MARCADOS]
                            - resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS]);
                }
                pos++;
            }
            out.format("|=====|=====|=================|====|====|====|====|====|====|====|====|\n");
        }
    }

    private static void listarEquipasComMaximoGolosMarcados(String[][] equipas, int[][] resultados, int contador) {

        // 1ª iteração ir buscar o máximo de golos marcados
        int max = -1;
        for (int i = 0; i < contador; i++) {
            if (resultados[i][COLUNA_GOLOS_MARCADOS] > max) {
                max = resultados[i][COLUNA_GOLOS_MARCADOS];
            }
        }
        out.format("| Equipa          | GM  |\n");
        out.format("|=================|=====|\n");
        for (int i = 0; i < contador; i++) {
            if (resultados[i][COLUNA_GOLOS_MARCADOS] == max) {
                out.format("|%-17s|%5d|\n", equipas[i][COLUNA_EQUIPA], resultados[i][COLUNA_GOLOS_MARCADOS]);
            }
        }
        out.format("|=================|=====|\n");
    }

    private static void listarEquipasComNGolosSofridos(String[][] equipas, int[][] resultados, int contador) {
        int golos;

        int quantidade = 0;
        do {
            out.format("Introduza o número de golos sofridos:\n");
            golos = in.nextInt();
        } while (golos < 0);
        for (int j = 0; j < contador; j++) {
            if (resultados[j][COLUNA_GOLOS_SOFRIDOS] == golos) {
                quantidade = quantidade + 1;
            }
        }
        if (quantidade >= 1) {
            out.format("\n| Equipa          | GS  |\n");
            out.format("|=================|=====|\n");

            for (int i = 0; i < contador; i++) {
                if (resultados[i][COLUNA_GOLOS_SOFRIDOS] == golos) {
                    out.format("|%-17s|%5d|\n", equipas[i][COLUNA_EQUIPA], resultados[i][COLUNA_GOLOS_SOFRIDOS]);
                }
            }
            out.format("|=================|=====|\n");
        } else {
            out.format("Não foi encontrada nenhuma equipa com esse número de golos sofridos");
        }
    }

    private static void listarEquipasComMaisGoloSofridosDoQueMarcados(String[][] equipas, int[][] resultados,
            int contador) {

        int[] lista = new int[MAXIMO_LINHAS];
        int contadorLista = 0;
        // primeira iteracao - colocar num array as equipas com mais golos sofridos do
        // que marcados
        for (int i = 0; i < contador; i++) {
            if (resultados[i][COLUNA_GOLOS_SOFRIDOS] > resultados[i][COLUNA_GOLOS_MARCADOS]) {
                lista[contadorLista] = i;
                contadorLista++;
            }
        }
        if (contadorLista != 0) {
            // Ordenar a lista alfabeticamente
            for (int i = 0; i < contadorLista; i++) {
                for (int j = i + 1; j < contadorLista; j++) {
                    String a = equipas[lista[i]][COLUNA_EQUIPA];
                    String b = equipas[lista[j]][COLUNA_EQUIPA];
                    if (a.compareToIgnoreCase(b) > 0) {
                        int temp = lista[i];
                        lista[i] = lista[j];
                        lista[j] = temp;
                    }
                }
            }
            // listar
            out.format("| Equipa          | GM  | GS  |\n");
            out.format("|=================|=====|=====|\n");
            for (int i = 0; i < contadorLista; i++) {
                out.format("|%-17s|%5d|%5d|\n", equipas[lista[i]][COLUNA_EQUIPA],
                        resultados[lista[i]][COLUNA_GOLOS_MARCADOS], resultados[lista[i]][COLUNA_GOLOS_SOFRIDOS]);
            }
            out.format("|=================|=====|=====|\n");
        } else {
            out.format("Não há nenhuma equipa com mais golos sofridos do que marcados");
        }
    }

    private static void calcularClassificacao(String[][] equipas, int[][] resultados, int contador,
            String[][] classificacao) {

        for (int i = 0; i < contador; i++) {
            classificacao[i][COLUNA_CLASSIFICACAO_GRUPO] = equipas[i][COLUNA_GRUPO];
            classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA] = Integer.toString(i);
        }
        // (1) número de pontos; (2) golos marcados; (3) menos golos sofridos; (4) menor
        // nome da equipa (ordem alfabética);
        for (int linha = 0; linha < contador; linha = linha + 1) {
            for (int linha1 = linha + 1; linha1 < contador; linha1 = linha1 + 1) {
                int idxEquipa1 = Integer.parseInt(classificacao[linha][COLUNA_CLASSIFICACAO_EQUIPA]);
                int idxEquipa2 = Integer.parseInt(classificacao[linha1][COLUNA_CLASSIFICACAO_EQUIPA]);
                boolean troca = false;
                if (classificacao[linha1][COLUNA_CLASSIFICACAO_GRUPO] != null
                        && classificacao[linha][COLUNA_CLASSIFICACAO_GRUPO] != null) {
                    if (!classificacao[linha][COLUNA_CLASSIFICACAO_GRUPO]
                            .equalsIgnoreCase(classificacao[linha1][COLUNA_CLASSIFICACAO_GRUPO])) {
                        break;
                    }
                    // Verificar pontos
                    if (resultados[idxEquipa1][COLUNA_PONTUACAO] < resultados[idxEquipa2][COLUNA_PONTUACAO]) {
                        troca = true;
                    } else if (resultados[idxEquipa1][COLUNA_PONTUACAO] == resultados[idxEquipa2][COLUNA_PONTUACAO]) {
                        // Verificar golos marcados
                        if (resultados[idxEquipa1][COLUNA_GOLOS_MARCADOS] < resultados[idxEquipa2][COLUNA_GOLOS_MARCADOS]) {
                            troca = true;
                        } else if (resultados[idxEquipa1][COLUNA_GOLOS_MARCADOS] == resultados[idxEquipa2][COLUNA_GOLOS_MARCADOS]) {
                            // Verificar golos sofridos
                            if (resultados[idxEquipa1][COLUNA_GOLOS_SOFRIDOS] < resultados[idxEquipa2][COLUNA_GOLOS_SOFRIDOS]) {
                                troca = true;
                            } else if (resultados[idxEquipa1][COLUNA_GOLOS_SOFRIDOS] == resultados[idxEquipa2][COLUNA_GOLOS_SOFRIDOS]) {
                                // Por nome da equipa
                                troca = (equipas[idxEquipa1][COLUNA_EQUIPA]
                                        .compareTo(equipas[idxEquipa2][COLUNA_EQUIPA]) > 0);
                            }
                        }
                    }
                }
                if (troca) {
                    String temp_grupo = classificacao[linha][COLUNA_CLASSIFICACAO_GRUPO];
                    String temp_equipa = classificacao[linha][COLUNA_CLASSIFICACAO_EQUIPA];
                    classificacao[linha][COLUNA_CLASSIFICACAO_GRUPO] = classificacao[linha1][COLUNA_CLASSIFICACAO_GRUPO];
                    classificacao[linha][COLUNA_CLASSIFICACAO_EQUIPA] = classificacao[linha1][COLUNA_CLASSIFICACAO_EQUIPA];
                    classificacao[linha1][COLUNA_CLASSIFICACAO_GRUPO] = temp_grupo;
                    classificacao[linha1][COLUNA_CLASSIFICACAO_EQUIPA] = temp_equipa;
                }
            }
        }
    }

    private static int inserirNovoRegisto(String[][] equipas, int[][] resultados, int contador) {

        boolean verificaCondicoes = false;
        while (!verificaCondicoes) {
            out.format("Introduz o novo registo (Exemplo de formato: B,Portugal,3,1,2,0,5,4):\n");
            String registo = in.next();
            verificaCondicoes = true;
            if (registo == null) {
                out.format("Introduza um registo válido!\n");
                verificaCondicoes = false;
            }
            assert registo != null;
            if (!registo.equalsIgnoreCase("Sair")) {
                String[] temp = registo.split(",");
                if (temp.length != 8) {
                    out.format("Introduza um registo válido!\n");
                    verificaCondicoes = false;
                } else if (grupoCheio(temp[0], equipas, contador)) {
                    out.format("O grupo já está cheio!\n");
                    verificaCondicoes = false;
                } else if (equipaExiste(temp[1], equipas, contador)) {
                    out.format("Já existe uma quipa com o mesmo nome!\n");
                    verificaCondicoes = false;
                } else if ((Integer.parseInt(temp[3]) + Integer.parseInt(temp[4])
                        + Integer.parseInt(temp[5])) != Integer.parseInt(temp[2])) {
                    out.format("O numero de jogos nao corresponde ao numero de vitorias, empates e derrotas!\n");
                    verificaCondicoes = false;
                }
                if (verificaCondicoes == true) {
                    inserirRegisto(equipas, resultados, contador, temp);
                    out.format("A equipa foi inserida com sucesso!");
                }
            }
        }
        return contador + 1;
    }

    private static void listarClassificacao(String[][] classificacao, String[][] equipas, int[][] resultados,
            int contador) {

        int pos = -1;
        String grupoAtual = "";
        for (int i = 0; i < contador; i++) {
            int idxEquipa = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]);
            if (classificacao[idxEquipa][COLUNA_CLASSIFICACAO_GRUPO] != null) {
                if (!grupoAtual.equalsIgnoreCase(equipas[idxEquipa][COLUNA_GRUPO])) {
                    if (!grupoAtual.isEmpty()) {
                        out.format("|=====|=====|=================|====|====|====|====|====|====|====|====|\n\n");
                    }
                    pos = 1;
                    grupoAtual = equipas[idxEquipa][COLUNA_GRUPO];
                    out.format("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD |\n");
                    out.format("|=====|=====|=================|====|====|====|====|====|====|====|====|\n");
                }
                out.format("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", equipas[idxEquipa][COLUNA_GRUPO], pos,
                        equipas[idxEquipa][COLUNA_EQUIPA], resultados[idxEquipa][COLUNA_PONTUACAO],
                        resultados[idxEquipa][COLUNA_JOGOS], resultados[idxEquipa][COLUNA_VITORIAS],
                        resultados[idxEquipa][COLUNA_EMPATES], resultados[idxEquipa][COLUNA_DERROTAS],
                        resultados[idxEquipa][COLUNA_GOLOS_MARCADOS], resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS],
                        resultados[idxEquipa][COLUNA_GOLOS_MARCADOS] - resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS]);
                pos++;
            }
        }
        out.format("|=====|=====|=================|====|====|====|====|====|====|====|====|\n\n");
    }

    private static void listarPrimeiroClassificadoDeCadaGrupo(String[][] classificacao, String[][] equipas,
            int[][] resultados, int contador) {

        String grupoAtual = "";
        out.format("| Grp | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD |\n");
        out.format("|=====|=================|====|====|====|====|====|====|====|====|\n");
        for (int i = 0; i < contador; i++) {
            int idxEquipa = Integer.parseInt(classificacao[i][COLUNA_CLASSIFICACAO_EQUIPA]);
            if (classificacao[idxEquipa][COLUNA_CLASSIFICACAO_GRUPO] != null) {
                if (!grupoAtual.equalsIgnoreCase(equipas[idxEquipa][COLUNA_GRUPO])) {
                    grupoAtual = equipas[idxEquipa][COLUNA_GRUPO];
                    out.format("|%-5s|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", equipas[idxEquipa][COLUNA_GRUPO],
                            equipas[idxEquipa][COLUNA_EQUIPA], resultados[idxEquipa][COLUNA_PONTUACAO],
                            resultados[idxEquipa][COLUNA_JOGOS], resultados[idxEquipa][COLUNA_VITORIAS],
                            resultados[idxEquipa][COLUNA_EMPATES], resultados[idxEquipa][COLUNA_DERROTAS],
                            resultados[idxEquipa][COLUNA_GOLOS_MARCADOS], resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS],
                            resultados[idxEquipa][COLUNA_GOLOS_MARCADOS]
                            - resultados[idxEquipa][COLUNA_GOLOS_SOFRIDOS]);
                }
            }
        }
        out.format("|=====|=================|====|====|====|====|====|====|====|====|\n\n");

    }

    private static int lerFicheiro(String[][] equipas, int[][] resultados) throws FileNotFoundException {

        String novoFicheiro = FICHEIRO;
        int contadorDeEquipas = 0;
        Scanner sc = new Scanner(new FileReader(novoFicheiro));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                String[] registo = linha.split(",");
                if (registo.length == MAXIMO_COLUNAS) {
                    inserirRegisto(equipas, resultados, contadorDeEquipas, registo);
                    contadorDeEquipas++;
                }
            }
        }
        sc.close();
         for (String[] g : equipas) {
                    System.out.println(Arrays.toString(g));
         }
        return contadorDeEquipas;
    }

    private static int lerNovoFicheiro(String[][] equipas, int[][] resultados) throws FileNotFoundException {

        Scanner ficheiro = new Scanner(System.in);
        System.out.println("Insira o nome do ficheiro");
        String novoFicheiro = ficheiro.nextLine();
        if (novoFicheiro.equals("")) {
            novoFicheiro = FICHEIRO;
        }
        int contadorDeEquipas = 0;
        Scanner sc = new Scanner(new FileReader(novoFicheiro));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                String[] registo = linha.split(",");
                if (registo.length == MAXIMO_COLUNAS) {
                    inserirRegisto(equipas, resultados, contadorDeEquipas, registo);
                    contadorDeEquipas++;
                }
            }
        }
        System.out.println(equipas+"\n"+resultados);
        sc.close();
        return contadorDeEquipas;
    }

    private static boolean equipaExiste(String equipa, String[][] equipas, int contador) {

        for (int i = 0; i < contador; i++) {
            if (equipas[i][COLUNA_EQUIPA] != null) {
                if (equipas[i][COLUNA_EQUIPA].equalsIgnoreCase(equipa)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean grupoCheio(String grupo, String[][] equipas, int contador) {

        int contadorDeEquipas = 0;
        for (int i = 0; i < contador; i++) {
            if (equipas[i][COLUNA_GRUPO] != null) {
                if (equipas[i][COLUNA_GRUPO].equalsIgnoreCase(grupo)) {
                    contadorDeEquipas = contadorDeEquipas + 1;
                }
            }
        }
        if (contadorDeEquipas > MAXIMO_EQUIPAS_GRUPO - 1) {
            return true;
        } else {
            return false;
        }
    }

    private static void inserirRegisto(String[][] equipas, int[][] resultados, int posicao, String[] registo) {

        equipas[posicao][COLUNA_GRUPO] = registo[0];
        equipas[posicao][COLUNA_EQUIPA] = registo[1];
        resultados[posicao][COLUNA_JOGOS] = Integer.parseInt(registo[2]);
        resultados[posicao][COLUNA_VITORIAS] = Integer.parseInt(registo[3]);
        resultados[posicao][COLUNA_EMPATES] = Integer.parseInt(registo[4]);
        resultados[posicao][COLUNA_DERROTAS] = Integer.parseInt(registo[5]);
        resultados[posicao][COLUNA_GOLOS_MARCADOS] = Integer.parseInt(registo[6]);
        resultados[posicao][COLUNA_GOLOS_SOFRIDOS] = Integer.parseInt(registo[7]);

    }

    private static void calcularPontuacao(String[][] equipas, int[][] resultados, int contadorDeEquipas) {

        for (int i = 0; i < contadorDeEquipas; i++) {
            resultados[i][COLUNA_PONTUACAO] = resultados[i][COLUNA_VITORIAS] * 3 + resultados[i][COLUNA_EMPATES] * 1;
        }
    }

    private static void ordenarEquipasPorGrupos(String[][] equipas, int[][] resultados, int contadorDeEquipas) {

        for (int linha = 0; linha < contadorDeEquipas; linha = linha + 1) {
            for (int linha1 = linha + 1; linha1 < contadorDeEquipas; linha1 = linha1 + 1) {
                String a = equipas[linha1][COLUNA_GRUPO];
                String b = equipas[linha][COLUNA_GRUPO];
                if (a != null && b != null) {
                    if (a.compareToIgnoreCase(b) <= -1) {
                        // .....[troca grupoes e equipas]
                        String grupo = equipas[linha][COLUNA_GRUPO];
                        equipas[linha][COLUNA_GRUPO] = equipas[linha1][COLUNA_GRUPO];
                        equipas[linha1][COLUNA_GRUPO] = grupo;
                        String equipa = equipas[linha][COLUNA_EQUIPA];
                        equipas[linha][COLUNA_EQUIPA] = equipas[linha1][COLUNA_EQUIPA];
                        equipas[linha1][COLUNA_EQUIPA] = equipa;
                        // .....[troca resultados]
                        int[] resultado = resultados[linha];
                        resultados[linha] = resultados[linha1];
                        resultados[linha1] = resultado;
                    }
                }
            }
        }
    }

    private static void escreverlistarInformacaoJogos(String[][] equipas, int[][] resultados, String[][] classificacao,
            int contadorDeEquipas) {

        int somaVitorias = 0, somaEmpates = 0, somaDerrotas = 0, somaJogos = 0, somaGolosMarcados = 0,
                somaGolosSofridos = 0;
        float mediaGolosMarcados, mediaGolosSofridos;
        for (int i = 0; i < contadorDeEquipas; i++) {
            somaJogos += resultados[i][COLUNA_JOGOS];
            somaVitorias += resultados[i][COLUNA_VITORIAS];
            somaDerrotas += resultados[i][COLUNA_DERROTAS];
            somaJogos += resultados[i][COLUNA_JOGOS];
            somaGolosMarcados += resultados[i][COLUNA_GOLOS_MARCADOS];
            somaGolosSofridos += resultados[i][COLUNA_GOLOS_SOFRIDOS];
        }
        mediaGolosMarcados = (float) somaGolosMarcados / (float) somaJogos;
        mediaGolosSofridos = (float) somaGolosSofridos / (float) somaJogos;
        Formatter outFile;
        try {
            outFile = new Formatter("Statistics.txt");
            outFile.format("Total de jogos=%d\n", somaJogos);
            outFile.format("Total de vitórias=%d\n", somaVitorias);
            outFile.format("Total de derrotas=%d\n", somaDerrotas);
            outFile.format("Total de golos marcados=%d\n", somaGolosMarcados);
            outFile.format("Total de golos sofridos=%d\n", somaGolosSofridos);
            outFile.format("Média de golos marcados por jogo=%.1f\n", mediaGolosMarcados);
            outFile.format("Média de golos sofridos por jogo=%.1f\n", mediaGolosSofridos);
            outFile.close();
            out.format("O Ficheiro foi gravado com sucesso!\n");
        } catch (FileNotFoundException ex) {
            out.format("Ocorreu um erro ao gravar para o ficheiro!\n");
        }
    }

    private static void escreverEquipasFaseFinal(String[][] equipasAux, int[][] resultadosAux,
            String[][] classificacaoAux, int contadorDeEquipas) {

        Formatter outFile;
        try {
            outFile = new Formatter("FinalStage.csv");
            String grupoAtual = "";
            int pos = 1;
            for (int i = 0; i < contadorDeEquipas; i++) {
                int idx = Integer.parseInt(classificacaoAux[i][COLUNA_CLASSIFICACAO_EQUIPA]);
                if (!grupoAtual.equalsIgnoreCase(classificacaoAux[i][COLUNA_CLASSIFICACAO_GRUPO])) {
                    pos = 1;
                    grupoAtual = classificacaoAux[i][COLUNA_CLASSIFICACAO_GRUPO];
                }
                outFile.format("%s,%d,%s,%d\n", classificacaoAux[idx][COLUNA_CLASSIFICACAO_GRUPO], pos,
                        equipasAux[idx][COLUNA_EQUIPA], resultadosAux[idx][COLUNA_PONTUACAO]);
                pos++;
            }
            outFile.close();
            out.format("O Ficheiro foi gravado com sucesso!\n");
        } catch (FileNotFoundException ex) {
            out.format("Ocorreu um erro ao gravar para o ficheiro!\n");
        }
    }
}
