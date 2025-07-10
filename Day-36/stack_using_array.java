class MyStack {
    private int[] stack;
    private int top;
    private int capacity;

    public MyStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

public class stack_using_array {
        public static void main(String[] args) {
            System.out.println("== Stack ==");
            MyStack stack = new MyStack(5);
            stack.push(10);
            stack.push(20);
            System.out.println("Top: " + stack.peek());  // 20
            stack.pop();
            System.out.println("Top after pop: " + stack.peek());  // 10

        }

}
