
import java.util.Scanner;

public class ExB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAlunos, numDisciplinas, alunosAprovados;
        String nomeDisciplina;

        //insira o numero de alunos e disciplinas
        numAlunos = sc.nextInt();
        numDisciplinas = sc.nextInt();

        //insira a Disciplina e o numero de alunos aprovados
        for (int i = 0; i < numDisciplinas; i++) {
            nomeDisciplina = sc.next();
            alunosAprovados = sc.nextInt();
            infoDisciplina(nomeDisciplina, alunosAprovados, numAlunos);
        }
    }
//------------------------------------------------------------------------------

    public static void infoDisciplina(String nomeDisciplina, int alunosAprovados, int numAlunos) {

        System.out.println("Disciplina: " + nomeDisciplina);
        System.out.print("- Positivas: ");
        for (int i = 0; i < alunosAprovados; i++) {
            System.out.print("*");
        }
        System.out.println("");
        System.out.print("- Negativas: ");
        for (int j = 0; j < (numAlunos - alunosAprovados); j++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}
