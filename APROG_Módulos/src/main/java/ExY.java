public class ExY {
    public static void main(String[] args) {
        multipleOfThree(30);
    }

    static void multipleOfThree(int number) {
        Integer[] divisores = findCountOfDivisors(number);
        Integer[] multiplosDeTres = new Integer[divisores.length];
        int index = 0;
        for (Integer i : divisores) {
            if (i != null && i != number) {
                if (i % 3 == 0) {
                    multiplosDeTres[index] = i;
                    index++;
                }
            }
        }
        for (Integer i : multiplosDeTres) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }


    static Integer[] findCountOfDivisors(int no) {
        Integer[] array = new Integer[100];
        //variable to store the result
        int index = 0;
        //start a loop and check for each number if it can divide the given number
        for (int i = 1; i <= no; i++) {
            if (no % i == 0) {
                array[index] = no / i;
                index++;
            }
        }
        return array;
    }
}
