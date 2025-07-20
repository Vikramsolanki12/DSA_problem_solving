import java.util.*;

public class HitCounter {
    private Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(300);
        System.out.println(counter.getHits(300)); // 3
        counter.hit(301);
        System.out.println(counter.getHits(301)); // 3 (1 is expired)
    }
}
