import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileExporter {

    private BufferedWriter writer;

    public FileExporter(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename + ".txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportToFile(String data) {
        try {
            this.writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeStream() {
        try {
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
