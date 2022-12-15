import java.util.LinkedList;
import java.util.List;

public class ExJ {
    public static void main(String[] args) {
        Integer[] a = {3, 123, 6, 200};
        numberPercentage(a);
    }

    static void numberPercentage(Integer[] numbers) {
        double max = 0.0;
        for (Integer number : numbers) {
            if (number < 0) {
                return;
            }
            int count = 0;
            int numTemp = number;
            List<Integer> a = findCountOfDivisors(numTemp);
            while (numTemp > 0) {
                if (a.contains(numTemp % 10)) {
                    count++;
                }
                numTemp /= 10;
            }
            if (max < (double) 100 * count / String.valueOf(number).length()) {
                max = (double) 100 * count / String.valueOf(number).length();
            }
            System.out.println((double) 100 * count / String.valueOf(number).length() + "%");
        }
        System.out.println("(" + max + "%)");
    }

    static List<Integer> findCountOfDivisors(int no) {
        List<Integer> a = new LinkedList<>();
        for (int i = 1; i <= no; i++) {
            if (no % i == 0) {
                if (no / i != 0) {
                    a.add(no / i);
                }
            }
        }
        return a;
    }
}
