public class ExH {
    public static void main(String[] args) {
        numeroPrimoCheck(27);
        numeroPrimoCheck(31);

    }

    static void numeroPrimoCheck(int numero) {
        int count = 0;
        int numTemp = numero;
        while (numTemp > 0) {
            if (numero % numTemp == 0) {
                count++;
            }
            numTemp--;
        }
        if (count == 2) {

            System.out.println("É primo");
            return;
        }
        System.out.println("Não é primo");
    }
}
