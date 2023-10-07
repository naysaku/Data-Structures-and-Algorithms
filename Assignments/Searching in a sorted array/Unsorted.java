public class Unsorted {

    public static boolean search(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (element == array[i])
                return true;
        }
        return false;
    }

}
