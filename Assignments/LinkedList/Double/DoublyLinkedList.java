public class DoublyLinkedList {
    public Cell first;
    private int size;

    public class Cell {
        public int head;
        public Cell next;
        public Cell prev;

        Cell(int val) {
            this.head = val;
            this.next = null;
            this.prev = null;
        }
    }

    // Unlink a specific cell
    public void unlink(Cell cell) {
        if (cell.prev != null) {
            cell.prev.next = cell.next;
        } else {
            first = cell.next;
        }
        if (cell.next != null) {
            cell.next.prev = cell.prev;
        }
        size--;
    }

    // Insert a cell as the first cell in the list
    public void insert(Cell cell) {
        cell.next = first;
        if (first != null) {
            first.prev = cell;
        }
        first = cell;
        size++;
    }
}
