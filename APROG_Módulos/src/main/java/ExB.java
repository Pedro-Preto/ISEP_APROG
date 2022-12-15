import java.util.LinkedList;
import java.util.List;

public class ExB {
    public static void main(String[] args) {
        Integer[] a = {36781, 4567, 10003, -1};
        for (Integer o : a) {
            somarAlgarismosPares(o);
        }
    }

    private static Comparable<Integer> somarAlgarismosPares(int number) {
        if (number < 0) {
            return null;
        }
        int total = 0;
        while (number > 0) {
            if ((number % 10) % 2 == 0) {
                total += number % 10;
            }
            number = number / 10;
        }
        System.out.println(total);
        return total;
    }
}
