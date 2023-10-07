import java.util.Random;

public class Benchmark {

    public static void selectionSort() {
        FileExporter fileExporter = new FileExporter("[Sorted] Selection sort");

        fileExporter.exportToFile("Time (ms):\n");
        int[] sizes = { 1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 }; // You can
                                                                                                       // adjust these
        // sizes as needed

        for (int size : sizes) {
            int[] array = generateAscendingArray(size);

            long startTime = System.currentTimeMillis();
            Sort.selectionSort(array);
            long endTime = System.currentTimeMillis();
            fileExporter.exportToFile((endTime - startTime) + "\n");
            System.out.println("Size: " + size + " | Time taken (ms): " + (endTime - startTime));

        }
        fileExporter.exportToFile("Sizes (n): \n");

        for (int i = 0; i < sizes.length; i++) {
            fileExporter.exportToFile(sizes[i] + "\n");
        }
        fileExporter.closeStream();
    }

    public static void insertionSort() {
        FileExporter fileExporter = new FileExporter("[Sorted] Insertion sort");

        fileExporter.exportToFile("Time (ms):\n");
        int[] sizes = { 1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 }; // You can
                                                                                                       // adjust these
        // sizes as needed

        for (int size : sizes) {
            int[] array = generateAscendingArray(size);

            long startTime = System.currentTimeMillis();
            Sort.insertionSort(array);
            long endTime = System.currentTimeMillis();
            fileExporter.exportToFile((endTime - startTime) + "\n");
            System.out.println("Size: " + size + " | Time taken (ms): " + (endTime - startTime));

        }
        fileExporter.exportToFile("Sizes (n): \n");

        for (int i = 0; i < sizes.length; i++) {
            fileExporter.exportToFile(sizes[i] + "\n");
        }
        fileExporter.closeStream();
    }

    public static void mergeSort() {
        FileExporter fileExporter = new FileExporter("[Sorted] Merge sort");

        fileExporter.exportToFile("Time (ms):\n");
        int[] sizes = { 1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 };

        for (int size : sizes) {
            int[] array = generateAscendingArray(size);

            long startTime = System.currentTimeMillis();
            Mergee.sort(array);
            long endTime = System.currentTimeMillis();
            fileExporter.exportToFile((endTime - startTime) + "\n");
            System.out.println("Size: " + size + " | Time taken (ms): " + (endTime - startTime));

        }
        fileExporter.exportToFile("Sizes (n): \n");

        for (int i = 0; i < sizes.length; i++) {
            fileExporter.exportToFile(sizes[i] + "\n");
        }

        fileExporter.closeStream();
    }

    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(9);
        }
        return array;
    }

    public static int[] generateDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    public static int[] generateAscendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size + i;
        }
        return array;
    }

    public static int[] generatePartiallySortedArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        // Fill the array with values in ascending order
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        // Introduce some randomness to make it partially sorted
        // For simplicity, we'll swap a few random elements
        int numSwaps = size / 10; // Swap 10% of the elements
        for (int i = 0; i < numSwaps; i++) {
            int index1 = rand.nextInt(size);
            int index2 = rand.nextInt(size);

            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return array;
    }

}
