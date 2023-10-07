import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Benchmark {
    private static final int N = 30;
    private static final int K = 1000;
    private static final String OUTPUT_FILE = "benchmark_results.txt";

    public static void main(String[] args) {
        Singly singleList = new Singly();
        Doubly doubleList = new Doubly();

        Singly.Cell[] singleCellArray = new Singly.Cell[N];
        Doubly.Cell[] doubleCellArray = new Doubly.Cell[N];

        long[] singleTimes = new long[N];
        long[] doubleTimes = new long[N];

        Random rand = new Random();

        for (int length = 1; length <= N; length++) {
            Singly.Cell singleCell = singleList.new Cell(length, null);
            singleList.insertCell(singleCell);
            singleCellArray[length - 1] = singleCell;

            Doubly.Cell doubleCell = doubleList.new Cell(length, null, null);
            doubleList.insertCell(doubleCell);
            doubleCellArray[length - 1] = doubleCell;

            int[] randomIndices = new int[K];
            for (int i = 0; i < K; i++) {
                randomIndices[i] = rand.nextInt(length);
            }

            long startSingle = System.nanoTime();
            for (int i = 0; i < K; i++) {
                singleList.unlink(singleCellArray[randomIndices[i]]);
                singleList.insertCell(singleCellArray[randomIndices[i]]);
            }
            long endSingle = System.nanoTime();

            long startDouble = System.nanoTime();
            for (int i = 0; i < K; i++) {
                doubleList.unlink(doubleCellArray[randomIndices[i]]);
                doubleList.insertCell(doubleCellArray[randomIndices[i]]);
            }
            long endDouble = System.nanoTime();

            singleTimes[length - 1] = endSingle - startSingle;
            doubleTimes[length - 1] = endDouble - startDouble;
        }

        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write("Length of list:\n");
            for (int i = 1; i <= N; i++) {
                writer.write(i + "\n");
            }

            writer.write("\nTime for singly:\n");
            for (long time : singleTimes) {
                writer.write(time + "\n");
            }

            writer.write("\nTime for doubly:\n");
            for (long time : doubleTimes) {
                writer.write(time + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
