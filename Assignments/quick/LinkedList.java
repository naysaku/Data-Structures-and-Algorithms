public class LinkedList {
    Node head;
    Node tail;

    public void append(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void sort() {
        head = quickSort(head);
    }

    private Node quickSort(Node start) {
        if (start == null || start.next == null) return start;

        Node pivot = start;
        LinkedList smaller = new LinkedList();
        LinkedList larger = new LinkedList();

        Node curr = start.next;
        while (curr != null) {
            if (curr.value < pivot.value) {
                smaller.append(curr.value);
            } else {
                larger.append(curr.value);
            }
            curr = curr.next;
        }

        smaller.sort();
        larger.sort();

        if (smaller.tail != null) {
            smaller.tail.next = pivot;
            pivot.next = larger.head;
            return smaller.head;
        } else {
            pivot.next = larger.head;
            return pivot;
        }
    }
}
