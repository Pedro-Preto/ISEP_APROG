public class ExD {
    public static void main(String[] args) {
        Integer[] a = {56983, 321, 1234567, -1};
        for (Integer b : a) {
            produtoImpares(b);

        }
    }

    private static Comparable<Integer> produtoImpares(int number) {
        if (number < 0) {
            return null;
        }
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
