public class ExK {
    public static void main(String[] args) {
        numeroPrimoCheck(16);
    }

    static void numeroPrimoCheck(int numero) {
        Integer[] a = new Integer[numero];
        int index = 0;
        while (numero > 1) {
            int count = 0;
            int numTemp = numero;
            while (numTemp > 0) {
                if (numero % numTemp == 0) {
                    count++;
                }
                numTemp--;
            }
            if (count == 2) {
                a[index] = numero;
                index++;
            }

            numero--;
        }
        for (Integer ab : a) {
            if (ab != null) {
                System.out.println(ab);
            }
        }

    }
}
