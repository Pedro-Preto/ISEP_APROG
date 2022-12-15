public class ExF {
    public static void main(String[] args) {
        Integer[] a = {12345, 5005};
        for (Integer b : a) {
            capicua(b);
        }
    }

    private static void capicua(int number) {
        String numTemp = String.valueOf(number);
        int maxIndex = numTemp.length() - 1;
        int minIndex = 0;
        if (numTemp.length() % 2 == 0) {
            while (minIndex + 1 != maxIndex) {
                if (!String.valueOf(numTemp.charAt(minIndex)).equals(String.valueOf(numTemp.charAt(maxIndex)))) {
                    System.out.println("nao capicua");
                    return;
                }
                minIndex++;
                maxIndex--;
            }
            System.out.println("capicua");
        } else {
            while (minIndex != maxIndex) {
                if (!String.valueOf(numTemp.charAt(minIndex)).equals(String.valueOf(numTemp.charAt(maxIndex)))) {
                    System.out.println("nao capicua");
                    return;
                }
                minIndex++;
                maxIndex--;
            }
            System.out.println("capicua");
        }

    }
}
