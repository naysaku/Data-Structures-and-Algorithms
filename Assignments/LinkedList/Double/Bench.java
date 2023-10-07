import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Bench {
    private static final String FILE_NAME = "benchmark_results.txt";

    public static void main(String[] args) {
        writeToFile("Sizes (n):");
        for (int i = 1; i <= 80; i++) {
            writeToFile(Integer.toString(i));
        }

        writeToFile("\nTime for singly (ns):");
        singly();

        writeToFile("\nTime for doubly (ns):");
        doubly();
    }

    public static void singly() {
        int[] sizes = { /* ... your sizes ... */ };

        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedList.Cell[] sllCells = new SinglyLinkedList.Cell[sizes[sizes.length - 1]];

        for (int n : sizes) {
            for (int i = 0; i < n; i++) {
                sllCells[i] = sll.new Cell(i);
            }

            int[] indicesArray = getRandomIndices(n, 1000);

            long startTimeSLL = System.nanoTime();
            for (int index : indicesArray) {
                sll.unlink(sllCells[index]);
                sll.insert(sllCells[index]);
            }
            long endTimeSLL = System.nanoTime();

            writeToFile(Long.toString(endTimeSLL - startTimeSLL));
        }
    }

    public static void doubly() {
        int[] sizes = { /* ... your sizes ... */ };

        DoublyLinkedList dll = new DoublyLinkedList();
        DoublyLinkedList.Cell[] dllCells = new DoublyLinkedList.Cell[sizes[sizes.length - 1]];

        for (int n : sizes) {
            for (int i = 0; i < n; i++) {
                dllCells[i] = dll.new Cell(i);
            }

            int[] indicesArray = getRandomIndices(n, 1000);

            long startTimeDLL = System.nanoTime();
            for (int index : indicesArray) {
                dll.unlink(dllCells[index]);
                dll.insert(dllCells[index]);
            }
            long endTimeDLL = System.nanoTime();

            writeToFile(Long.toString(endTimeDLL - startTimeDLL));
        }
    }

    private static int[] getRandomIndices(int n, int k) {
        int[] indices = new int[k];
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            indices[i] = random.nextInt(n);
        }
        return indices;
    }

    private static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
