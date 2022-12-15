import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Marta {

    private static final String FILE_MARTA = "questionnaire.txt";
    private static final List<String> questionary = new LinkedList();
    private static final List<String> answers = new LinkedList();

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        load();
    }


    public void Marta() {
    }

    public static void load() {

        try {
            System.out.println("========================================");

            readMarta();

            for (String a : answers) {
                FileSystem.outPutResume(a);
            }
            System.out.println("========================================");

        } catch (RuntimeException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro Tipo RunTime");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("System Error");
        }
    }

    public static void readMarta() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader((FILE_MARTA)));
        boolean flag = false;
        boolean flagSC = false;
        boolean flagTf = false;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            System.out.println(linha);
            questionary.add(linha);

            if (linha.equals("Q1.")) {
                flag = true;
            }
            if (flag) {
                if (linha.equals("Obligatoriness: Optional.")) {
                    String checkerCheckBox = "";
                    int count = 1;
                    while (!linha.equals("")) {
                        linha = sc.nextLine();
                        System.out.println(linha);
                        questionary.add(linha);
                        if (count == 2) {
                            checkerCheckBox = linha;
                        }
                        count++;
                    }
                    System.out.println("====================");
                    System.out.println("Do you wish to answer?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    String answer = in.nextLine();
                    System.out.println("====================");

                    if (answer.equals("2")) {
                        answers.add("Not Answered");
                        questionary.add(questionary.size() - 1, "Not Answered");

                        linha = sc.nextLine();
                        System.out.println(linha);
                        questionary.add(linha);
                    }
                    if (answer.equals("1") && checkerCheckBox.equals("Type: Single-Choice.")) {
                        flagSC = true;
                    } else if (answer.equals("1")) {
                        flagTf = true;
                    }
                }

                if (linha.equals("Type: Single-Choice.") || flagSC) {

                    while (!linha.equals("")) {
                        linha = sc.nextLine();
                        System.out.println(linha);
                        questionary.add(linha);
                    }
                    //  System.out.println(linha);

                    String answer = in.nextLine();
                    String finalAnswer = "";
                    int index = questionary.size() - 1;
                    while (finalAnswer.equals("")) {
                        try {
                            String[] aux = questionary.get(index).split(". ");
                            if (aux[0].equals(answer)) {
                                finalAnswer = aux[1];
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        index--;
                    }
                    questionary.add(questionary.size() - 1, "Answer:" + finalAnswer + "\n");
                    answers.add("Answer:" + finalAnswer);
                    flagSC = false;

                } else if (linha.equals("") || flagTf) {
                    String answer = in.nextLine();
                    if (!answer.equals("")) {
                        questionary.add(questionary.size() - 1, "Answer:" + answer + "\n");
                        answers.add("Answer:" + answer);

                    }
                    flagTf = false;
                }
            }
        }
        sc.close();
    }


}



