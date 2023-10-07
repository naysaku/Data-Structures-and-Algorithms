import java.util.Random;
import java.util.Scanner;

public class BenchmarkQuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum number of elements: ");
        final int MAX_ELEMENTS = scanner.nextInt();
        System.out.print("Enter the step size between each measurement: ");
        final int STEP_SIZE = scanner.nextInt();

        int numMeasurements = (int) Math.ceil((double) MAX_ELEMENTS / STEP_SIZE);
        long[] arrayTimes = new long[numMeasurements];
        long[] linkedListTimes = new long[numMeasurements];

        Random random = new Random();

        int measurementIndex = 0;
        for (int i = STEP_SIZE; i <= MAX_ELEMENTS; i += STEP_SIZE) {
            int[] array = new int[i];
            LinkedList list = new LinkedList();

            // Fill array and linked list with the same sequence of random numbers
            for (int j = 0; j < i; j++) {
                int value = random.nextInt(10000);
                array[j] = value;
                list.append(value);
            }

            // Measure sorting time for array
            int[] arrayCopy = array.clone();
            long startArrayTime = System.currentTimeMillis();
            QuickSortArray.sort(arrayCopy, 0, arrayCopy.length - 1);
            long endArrayTime = System.currentTimeMillis();
            arrayTimes[measurementIndex] = endArrayTime - startArrayTime;

            // Measure sorting time for linked list
            long startListTime = System.currentTimeMillis();
            list.sort();
            long endListTime = System.currentTimeMillis();
            linkedListTimes[measurementIndex] = endListTime - startListTime;

            measurementIndex++;
        }

        System.out.println("\nNumber of elements:");
        for (int i = STEP_SIZE; i <= MAX_ELEMENTS; i += STEP_SIZE) {
            System.out.println(i);
        }

        System.out.println("\nTime for array quicksort (in nanoseconds):");
        for (long time : arrayTimes) {
            System.out.println(time);
        }

        System.out.println("\nTime for linked list quicksort (in nanoseconds):");
        for (long time : linkedListTimes) {
            System.out.println(time);
        }

        scanner.close();
    }
}
