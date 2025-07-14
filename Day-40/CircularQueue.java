class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        System.out.println(q.enqueue(10));  // true
        System.out.println(q.enqueue(20));  // true
        System.out.println(q.enqueue(30));  // true
        System.out.println(q.enqueue(40));  // false (full)
        System.out.println(q.Rear());       // 30
        q.dequeue();
        System.out.println(q.enqueue(40));  // true
        System.out.println(q.Rear());       // 40
    }
}
