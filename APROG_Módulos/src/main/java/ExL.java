public class ExL {
    public static void main(String arg[]) {
        perfectNumbers(2);
    }

    private static void perfectNumbers(int size) {
        Integer[] array = new Integer[size];

        int index = 0, number = 1;
        while (index != size) {
            long p = perfectOrNot(number);
            if (p == number) {
                array[index] = number;
                index++;
            }
            number++;
        }
        for (Integer o : array) {
            System.out.println(o);

        }
    }

    static long perfectOrNot(long num) {
        long sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
