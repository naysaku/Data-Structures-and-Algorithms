import java.util.Random;

public class Benchmarking {

    public static void main(String[] args) {
        int[] sizes = { 10, 100, 1000, 5000, 10000 }; // Vary these sizes based on your requirements
        int k = 1000;

        for (int n : sizes)
            System.out.println(n);

        for (int n : sizes) {
            System.out.println("Benchmarking for n = " + n);

            SinglyLinkedList sll = new SinglyLinkedList();
            DoublyLinkedList dll = new DoublyLinkedList();

            SinglyLinkedList.Cell[] sllCells = new SinglyLinkedList.Cell[n];
            DoublyLinkedList.Cell[] dllCells = new DoublyLinkedList.Cell[n];

            // Initialization of cells
            for (int i = 0; i < n; i++) {
                sllCells[i] = sll.new Cell(i);
                dllCells[i] = dll.new Cell(i);
            }

            int[] indicesArray = getRandomIndices(n, k);

            // Benchmarking SinglyLinkedList
            long startTimeSLL = System.nanoTime();
            for (int index : indicesArray) {
                sll.unlink(sllCells[index]);
                sll.insert(sllCells[index]);
            }
            long endTimeSLL = System.nanoTime();

            // Benchmarking DoublyLinkedList
            long startTimeDLL = System.nanoTime();
            for (int index : indicesArray) {
                dll.unlink(dllCells[index]);
                dll.insert(dllCells[index]);
            }
            long endTimeDLL = System.nanoTime();

            // Display Results
            System.out.println("Time for SinglyLinkedList: " + (endTimeSLL - startTimeSLL));
            System.out.println("Time for DoublyLinkedList: " + (endTimeDLL - startTimeDLL));
            System.out.println();
        }
    }

    private static int[] getRandomIndices(int n, int k) {
        int[] indices = new int[k];
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            indices[i] = random.nextInt(n);
        }
        return indices;
    }
}
