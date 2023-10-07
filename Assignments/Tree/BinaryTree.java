import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }

        Node current = root;
        while (true) {
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = new Node(key, value);
                    return;
                } else {
                    current = current.left;
                }
            } else if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = new Node(key, value);
                    return;
                } else {
                    current = current.right;
                }
            } else { // key already exists, update the value
                current.value = value;
                return;
            }
        }
    }

    public Integer lookup(Integer key) {
        Node current = root;
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.value; // key found
            }
        }
        return null; // key not found
    }

    @Override
    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private Stack<Node> stack = new Stack<>();

        public TreeIterator() {
            next = root;
            while (next != null) {
                stack.push(next);
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            Node currentNode = stack.pop();

            if (currentNode.right != null) {
                next = currentNode.right;
                while (next != null) {
                    stack.push(next);
                    next = next.left;
                }
            }
            return currentNode.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
