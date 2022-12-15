import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TorneioDeMaltas {

    public static void main(String[] args) {
        LinkedList<String> equipas = new LinkedList<>();
        equipas.add("91/92/93");
        equipas.add("95/98");
        equipas.add("2002/2005");
        equipas.add("2006/2008");
        equipas.add("2007/2008");
        equipas.add("Emigrantes");


        int size = equipas.size();

        if (size % 2 == 0) {
            System.out.printf("%-6s %-6s %-10s%n", "|", "Grupo A", "|");
            System.out.println("|     2000/2001      |");

            while (equipas.size() != size / 2) {
                Random r = new Random();
                int random = r.nextInt(equipas.size() - 1);
                System.out.println("|      " + equipas.get(random) + "      |");
                equipas.remove(random);
            }
            System.out.printf("%n%n%-6s %-6s %-10s%n", "|", "Grupo B", "|");

            for (String e : equipas) {
                System.out.println("|      " + e + "      |");
            }
        } else {
            System.out.printf("%-6s %-6s %-10s%n", "|", "Grupo A", "|");
            System.out.println("|     2000/2001      |");

            while (equipas.size() != (size +2) / 2) {
                Random r = new Random();
                int random = r.nextInt(equipas.size() - 1);
                System.out.println("|      " + equipas.get(random) + "      |");
                equipas.remove(random);
            }
            System.out.printf("%n%n%-6s %-6s %-10s%n", "|", "Grupo B", "|");

            for (String e : equipas) {
                System.out.println("|      " + e + "      |");
            }
        }
    }

}