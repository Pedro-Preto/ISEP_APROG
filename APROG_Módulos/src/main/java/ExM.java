public class ExM {
    public static void main(String[] args) {
        fibonacci(5);
    }

    private static void fibonacci(int size) {
        Integer[] array = new Integer[size];
        int first = 0;
        int second = 1;
        int index = 2;
        array[0] = first;
        array[1] = second;
        while (index != size) {
            int third = first + second;
            array[index] = third;
            first = second;
            second = third;
            index++;
        }
        for (Integer a : array) {
            System.out.println(a);
        }
    }
}
