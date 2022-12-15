public class ExE {

// Java program to convert octal
// to decimal number using custom code

    public static void main(String[] args) {
        Integer[] a = {12345, 5000, 111, -1};
        for (Integer b : a) {
            convertToDecimal(b);

        }
    }

    private static Comparable<Integer> convertToDecimal(int number) {
        if (number < 0) {
            return null;
        }
        // Initialize result variable to 0.
        int result = 0;

        // Take a copy of input

        for (int i = 0; number > 0; i++) {

            // Take the last digit
            int temp = number % 10;

            // Appropriate power on 8 suitable to
            // its position.
            double p = Math.pow(8, i);

            // Multiply the digits to the into the Input
            // and
            // then add it to result
            result += (temp * p);
            number = number / 10;
        }

        System.out.println(result);

        return result;
    }

}

