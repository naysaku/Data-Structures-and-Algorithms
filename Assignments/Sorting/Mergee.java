public class Mergee {

    public static void sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length - 1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi) / 2;
            sort(org, aux, lo, mid);
            sort(org, aux, mid + 1, hi);
            merge(org, aux, lo, mid, hi);
        }
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = org[k];

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                org[k] = aux[j++];
            else if (j > hi)
                org[k] = aux[i++];
            else if (aux[i] < aux[j])
                org[k] = aux[i++];
            else
                org[k] = aux[j++];

        }
    }

}
