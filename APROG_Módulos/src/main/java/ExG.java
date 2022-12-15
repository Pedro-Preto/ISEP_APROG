public class ExG {
    public static void main(String[] args) {
        findCountOfDivisors(30);
    }

    static void findCountOfDivisors(int no) {

        //variable to store the result
        int result = 0;

        //start a loop and check for each number if it can divide the given number
        for (int i = 1; i <= no; i++) {
            if (no % i == 0) {
                System.out.println(no /i);

                //if the reminder is zero, increment the result variable

                result++;
            }
        }
        System.out.println("(" + result + ")");
    }
}