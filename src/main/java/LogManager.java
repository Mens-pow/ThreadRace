import java.io.FileWriter;
import java.io.IOException;

public class LogManager {


    static synchronized void write(String text) {
        writeToFile(text);
    }

    private static void writeToFile(String text) {

        try (FileWriter writer = new FileWriter("threadRace.txt", true)) {
            writer.write(text + System.getProperty("line.separator"));

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void writeToConsole(String text) {

        System.out.println(text);
    }
}
