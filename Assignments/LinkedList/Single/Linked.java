package Single;

import java.util.LinkedList;

class LinkedList {
    Cell first;

    private class Cell {
        int head;
        Cell tail;

        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    public LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }

    public void add(int item) {
        first = new Cell(item, first);
    }

    public int length() {
        int len = 0;
        Cell temp = first;
        while (temp != null) {
            len++;
            temp = temp.tail;
        }
        return len;
    }

    public boolean find(int item) {
        Cell temp = first;
        while (temp != null) {
            if (temp.head == item) {
                return true;
            }
            temp = temp.tail;
        }
        return false;
    }

    public void remove(int item) {
        if (first == null)
            return;

        if (first.head == item) {
            first = first.tail;
            return;
        }

        Cell temp = first;
        while (temp.tail != null) {
            if (temp.tail.head == item) {
                temp.tail = temp.tail.tail;
                return;
            }
            temp = temp.tail;
        }
    }

    public void append(LinkedList b) {
        Cell nxt = this.first;
        while (nxt != null && nxt.tail != null) {
            nxt = nxt.tail;
        }
        if (nxt != null) {
            nxt.tail = b.first;
        } else {
            this.first = b.first;
        }
        b.first = null;
    }
}
