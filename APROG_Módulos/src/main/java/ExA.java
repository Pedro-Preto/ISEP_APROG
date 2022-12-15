public class ExA {

    public static void main(String[] args) {
        somarAlgarismosPares(36781);
    }


    private static int somarAlgarismosPares(int number) {
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
