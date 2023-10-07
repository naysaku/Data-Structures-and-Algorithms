public class Singly {

    public class Cell {
        int head;
        Cell tail;

        public Cell(int val, Cell tl) {
            this.head = val;
            this.tail = tl;
        }
    }

    private Cell start = null;

    public void add(int item) {
        Cell newCell = new Cell(item, start);
        start = newCell;
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
        if (start == null)
            return;
        if (start.head == item) {
            start = start.tail;
            return;
        }
        Cell temp = start;
        while (temp.tail != null) {
            if (temp.tail.head == item) {
                temp.tail = temp.tail.tail;
                return;
            }
            temp = temp.tail;
        }
    }

    public void unlink(Cell cell) {
        if (start == cell) {
            start = cell.tail;
            return;
        }
        Cell temp = start;
        while (temp.tail != null && temp.tail != cell) {
            temp = temp.tail;
        }
        if (temp.tail == cell) {
            temp.tail = cell.tail;
        }
    }

    public void insertCell(Cell cell) {
        cell.tail = start;
        start = cell;
    }
}
