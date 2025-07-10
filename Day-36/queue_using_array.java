class MyQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public MyQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = queue[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class queue_using_array {
        public static void main(String[] args) {
            System.out.println("\n== Queue ==");
            MyQueue queue = new MyQueue(5);
            queue.enqueue(1);
            queue.enqueue(2);
            System.out.println("Front: " + queue.peek()); // 1
            queue.dequeue();
            System.out.println("Front after dequeue: " + queue.peek()); // 2
        }
}
