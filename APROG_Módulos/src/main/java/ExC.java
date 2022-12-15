public class ExC {
    public static void main(String[] args) {
        produtoImpares(56983);
    }

    private static int produtoImpares(int number) {
        int total = 0;
        while (number > 0) {
            if ((number % 10) % 2 != 0) {
                if (total == 0) {
                    total = number % 10;
                } else total *= number % 10;

            }
            number = number / 10;
        }
        System.out.println(total);
        return total;
    }
}
