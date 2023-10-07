import java.util.Random;

public class Merge {

    public static void sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length - 1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo >= hi)
            return; // Modified condition to handle edge cases
        int mid = (lo + hi) / 2;

        sort(org, aux, lo, mid); // sort the left half
        sort(org, aux, mid + 1, hi); // sort the right half

        merge(org, aux, lo, mid, hi); // merge the sorted halves
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // Copy all items from lo to hi from org to aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = org[k];
        }

        // Let's do the merging
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part

        // For all indices from lo to hi
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                org[k] = aux[j++];
            } else if (j > hi) {
                org[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                org[k] = aux[i++];
            } else {
                org[k] = aux[j++];
            }
        }
    }

    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(9);
        }
        return array;
    }

}
