public class Doubly {

    class Cell {
        int head;
        Cell tail;
        Cell prev;

        public Cell(int val, Cell tl, Cell prev) {
            this.head = val;
            this.tail = tl;
            this.prev = prev;
        }
    }

    private Cell start = null;
    private Cell end = null;

    public void add(int item) {
        Cell newCell = new Cell(item, null, null);
        if (start == null) {
            start = newCell;
            end = newCell;
        } else {
            newCell.tail = start;
            start.prev = newCell;
            start = newCell;
        }
    }

    public int length() {
        int count = 0;
        Cell temp = start;
        while (temp != null) {
            count++;
            temp = temp.tail;
        }
        return count;
    }

    public boolean find(int item) {
        Cell temp = start;
        while (temp != null) {
            if (temp.head == item)
                return true;
            temp = temp.tail;
        }
        return false;
    }

    public void remove(int item) {
        Cell temp = start;
        while (temp != null) {
            if (temp.head == item) {
                if (temp.prev != null)
                    temp.prev.tail = temp.tail;
                if (temp.tail != null)
                    temp.tail.prev = temp.prev;
                if (temp == start)
                    start = temp.tail;
                if (temp == end)
                    end = temp.prev;
                return;
            }
            temp = temp.tail;
        }
    }

    // Unlinking a specific cell from the list
    public void unlink(Cell cell) {
        if (cell.prev != null)
            cell.prev.tail = cell.tail;
        if (cell.tail != null)
            cell.tail.prev = cell.prev;
        if (cell == start)
            start = cell.tail;
        if (cell == end)
            end = cell.prev;
    }

    // Inserting a cell at the start
    public void insertCell(Cell cell) {
        cell.tail = start;
        cell.prev = null;
        if (start != null)
            start.prev = cell;
        start = cell;
        if (end == null)
            end = cell;
    }
}

// For singly linked list, you'll follow the same approach with only "head" and
// "next" references without "prev". The "unlink" method will traverse from the
// start to find the cell to unlink.
