import java.util.Stack;

public class queue_using_stack {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public queue_using_stack() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        shiftStacks();
        return popStack.pop();
    }

    public int peek() {
        shiftStacks();
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void shiftStacks() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        queue_using_stack q = new queue_using_stack();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());   // Output: 1
        System.out.println(q.pop());    // Output: 1
        System.out.println(q.empty());  // Output: false
    }
}
