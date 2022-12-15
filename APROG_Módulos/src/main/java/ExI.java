public class ExI {
    public static void main(String[] args) {
        lcm(12, 6);
        lcm(5, 4);

    }
    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absHigherNumber = Math.max(number1, number2);
        int absLowerNumber = Math.min(number1, number2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        System.out.println(lcm);
        return lcm;
    }
}