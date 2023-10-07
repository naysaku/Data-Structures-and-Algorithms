public class SinglyLinkedList {
    public Cell first;
    private int size;

    public class Cell {
        public int head;
        public Cell tail;

        Cell(int val) {
            this.head = val;
            this.tail = null;
        }
    }

    // Unlink a specific cell
    public void unlink(Cell cell) {
        Cell current = first;
        if (cell == first) {
            first = cell.tail;
            size--;
            return;
        }
        while (current != null && current.tail != cell) {
            current = current.tail;
        }
        if (current != null) {
            current.tail = cell.tail;
            size--;
        }
    }

    // Insert a cell as the first cell in the list
    public void insert(Cell cell) {
        cell.tail = first;
        first = cell;
        size++;
    }
}
