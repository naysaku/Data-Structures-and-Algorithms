public class DynamicStack extends Stack {

    private int top;

    private int capacity;

    private int[] stack;

    public DynamicStack(int capacity) {
        this.capacity = capacity;
        top = 0;
        stack = new int[capacity];
    }

    public void push(int value) {

        if (isFull()) {
            expandSize();
        }
        stack[++top] = value;

    }

    private void expandSize() {
        int currentSize = top + 1;
        int[] newStack = new int[capacity * 2];

        for (int i = 0; i < currentSize; i++) {
            newStack[i] = stack[i];
        }

        capacity = capacity * 2;
        stack = newStack;
    }

    public int pop() {
        int value = 0;
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            shrinkSize();
            value = stack[top];
            top--;
            return value;
        }
        return value;
    }

    private void shrinkSize() {

        if (getSize() <= (capacity / 4)) {

            capacity = capacity / 2;
            int newStack[] = new int[capacity];
            for (int i = 0; i < getSize(); i++) {
                newStack[i] = stack[i];
            }
            capacity = newStack.length;
        }
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (capacity - 1 == top)
            return true;
        return false;
    }

    public int getSize() {
        return top;
    }
}
