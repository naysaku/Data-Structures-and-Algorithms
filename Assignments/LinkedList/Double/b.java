import java.util.Random;

public class b {

    public static void main(String[] args) {
        printToConsole("Sizes:");
        for (int i = 1; i <= 80; i++) {
            printToConsole(Integer.toString(i));
        }
        printToConsole("\nSingly time:");
        singly();
        printToConsole("\nDoubly time:");
        doubly();
    }

    public static void singly() {
        int[] sizes = generateSizes();

        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedList.Cell[] sllCells = new SinglyLinkedList.Cell[sizes[sizes.length - 1]];

        for (int n : sizes) {
            int k = 1000;
            for (int i = 0; i < n; i++) {
                sllCells[i] = sll.new Cell(i);
            }

            int[] indicesArray = getRandomIndices(n, k);

            long startTimeSLL = System.nanoTime();
            for (int index : indicesArray) {
                sll.unlink(sllCells[index]);
                sll.insert(sllCells[index]);
            }
            long endTimeSLL = System.nanoTime();
            printToConsole(Long.toString(endTimeSLL - startTimeSLL));
        }
    }

    public static void doubly() {
        int[] sizes = generateSizes();

        DoublyLinkedList dll = new DoublyLinkedList();
        DoublyLinkedList.Cell[] dllCells = new DoublyLinkedList.Cell[sizes[sizes.length - 1]];

        for (int n : sizes) {
            int k = 1000;
            for (int i = 0; i < n; i++) {
                dllCells[i] = dll.new Cell(i);
            }

            int[] indicesArray = getRandomIndices(n, k);

            long startTimeDLL = System.nanoTime();
            for (int index : indicesArray) {
                dll.unlink(dllCells[index]);
                dll.insert(dllCells[index]);
            }
            long endTimeDLL = System.nanoTime();
            printToConsole(Long.toString(endTimeDLL - startTimeDLL));
        }
    }

    private static int[] generateSizes() {
        return new int[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
                71, 72, 73, 74, 75, 76, 77, 78, 79, 80
        };
    }

    private static int[] getRandomIndices(int n, int k) {
        int[] indices = new int[k];
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            indices[i] = random.nextInt(n);
        }
        return indices;
    }

    private static void printToConsole(String content) {
        System.out.println(content);
    }
}
