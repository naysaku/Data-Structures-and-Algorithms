import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class SortBenchmark {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 };
        Random rand = new Random();

        try (FileWriter writer = new FileWriter("benchmark_results.txt")) {
            writer.write("Size\tInsertion Sort (ms)\tSelection Sort (ms)\n");

            for (int size : sizes) {
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = rand.nextInt(1000000);
                }

                // Measure time for insertion sort
                long startInsertion = System.currentTimeMillis();
                insertionSort(arr.clone());
                long endInsertion = System.currentTimeMillis();

                // Measure time for selection sort
                long startSelection = System.currentTimeMillis();
                selectionSort(arr.clone());
                long endSelection = System.currentTimeMillis();

                writer.write(size + "\t" + (endInsertion - startInsertion) + "\t\t\t" + (endSelection - startSelection)
                        + "\n");
            }

            System.out.println("Benchmark results saved to benchmark_results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
