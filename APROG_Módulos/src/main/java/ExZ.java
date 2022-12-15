public class ExZ {
    public static void main(String[] args) {
        imparEpar(12345);
        System.out.println("============================");
        imparEpar(2004);
    }

    private static void imparEpar(int number) {
        int size = String.valueOf(number).length();
        int maxImpar = -1;
        int countPar = 0;

        while (number > 0) {
            if (number % 2 == 0) {
                countPar++;
            } else {
                if (number % 10 > maxImpar) {
                    maxImpar = number % 10;
                }
            }
            number = number / 10;
        }
        System.out.print(String.format("%.2f%% \n", (double) (countPar * 100) / size));
        if (maxImpar != -1) {
            System.out.println(maxImpar);
        } else {
            System.out.println("Não há algarismos impares");
        }

    }
}
