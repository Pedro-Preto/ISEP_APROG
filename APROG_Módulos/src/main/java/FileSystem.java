
import java.io.*;

public class FileSystem {

    private FileSystem() {
    }

    public static boolean outPutResume(String answer) {
        try {
            FileWriter myWriter;
            String outputLocation = null;
            outputLocation = "marta.txt";

            myWriter = new FileWriter(outputLocation, true);

            try {
                    myWriter.write(answer+"\n");

            } finally {
                myWriter.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error outputting the form request to a txt!");
            return false;
        }
        return true;

}


}
