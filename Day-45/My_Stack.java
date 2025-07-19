import java.util.LinkedList;
import java.util.Queue;

public class My_Stack {
    private Queue<Integer> q;

    public My_Stack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        while (size-- > 1) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        My_Stack stack = new My_Stack();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.top());   // 20
        System.out.println(stack.pop());   // 20
        System.out.println(stack.empty()); // false
    }
}
