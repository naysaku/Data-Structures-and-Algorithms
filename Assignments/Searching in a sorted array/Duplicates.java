public class Duplicates {

    // Linear
    public static int linear(int[] arrayOne, int[] arrayTwo) {
        int commonCount = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayOne.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) {
                    commonCount++;
                }
            }
        }
        return commonCount;
    }

    public static void betterDuplicateSearch(int[] sortedArray1, int[] sortedArray2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < (sortedArray1.length) && index2 < sortedArray2.length) {
            if (sortedArray2[index2] < sortedArray1[index1]) {
                index2++;
            } else if (sortedArray1[index1] == sortedArray2[index2]) {
                index1++;
                // System.out.println("duplicate found! " + sortedArray1[index1 - 1] +
                // sortedArray2[index2]);

            } else if (sortedArray1[index1] < sortedArray2[index2]) {
                index1++;
            }
            // System.out.println("no more duplicates");
            // System.out.println(index1);
        }
    }

    public static void findDuplicatesBetter(int[] arrayOne, int[] arrayTwo) {
        int i = 0;
        int j = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] == arrayTwo[j]) {
                i++;
                j++;
            } else if (arrayOne[i] < arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }
    }

    public static void findDuplicatesBetter2(int[] arrayOne, int[] arrayTwo) {
        int i = 0;
        int j = 0;

        for (; i < arrayOne.length && j < arrayTwo.length;) {
            if (arrayOne[i] == arrayTwo[j]) {
                i++;
                j++;
            } else if (arrayOne[i] < arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }
    }

}
