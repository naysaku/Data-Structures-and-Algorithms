public class Linear {

    // Unsorted
    public static boolean search(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element)
                return true;
        }
        return false;
    }

    // Sorted
    public static boolean sortedSearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
            if (array[i] > element) {
                return false;
            }
        }
        return false;
    }
}
