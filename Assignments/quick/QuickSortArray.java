public class QuickSortArray {
    public static void sort(int[] array, int min, int max) {
        if (min < max) {
            int pivotIndex = partition(array, min, max);
            sort(array, min, pivotIndex - 1);
            sort(array, pivotIndex + 1, max);
        }
    }

    private static int partition(int[] array, int min, int max) {
        int pivot = array[max];
        int i = min;
        for (int j = min; j < max; j++) {
            if (array[j] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[max];
        array[max] = temp;
        return i;
    }
}
