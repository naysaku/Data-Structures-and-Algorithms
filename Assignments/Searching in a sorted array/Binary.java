public class Binary {

    public static boolean search(int[] array, int element) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int midPosition = (low + high) / 2;
            int midElement = array[midPosition];

            if (element == midElement)
                return true;

            if (element < midElement)
                high = midPosition - 1;
            else {
                low = midPosition + 1;
            }

        }
        return false;
    }
}
