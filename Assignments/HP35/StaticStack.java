public class StaticStack extends Stack {

    private int top;

    private int[] stack;

    public StaticStack(int fixedSize) {
        top = 0;
        stack = new int[fixedSize];
    }

    public void push(int value) {

        if (isFull())
            System.out.println("Stack overflow");
        else {
            stack[top] = value;
            top++;
        }
    }

    public int pop() {
        int value = 0;
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
            value = stack[top];
        }
        return value;
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (top == stack.length)
            return true;
        return false;
    }
}
