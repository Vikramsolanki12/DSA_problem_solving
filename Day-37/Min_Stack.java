import java.util.Stack;

public class Min_Stack {
        private Stack<Integer> mainStack;
        private Stack<Integer> minStack;

        public Min_Stack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            mainStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek())
                minStack.push(val);
        }

        public void pop() {
            if (mainStack.peek().equals(minStack.peek()))
                minStack.pop();
            mainStack.pop();
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

    public static void main(String[] args) {
        Min_Stack stack = new Min_Stack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.getMin()); // 3
        stack.pop(); // removes 7
        stack.pop(); // removes 3
        System.out.println(stack.getMin()); // 5

    }

}
