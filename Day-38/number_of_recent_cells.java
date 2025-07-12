import java.util.LinkedList;
import java.util.Queue;

public class number_of_recent_cells {
    private Queue<Integer> queue;

    // Constructor
    public number_of_recent_cells() {
        queue = new LinkedList<>();
    }

    // Ping method
    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    // Main method to test
    public static void main(String[] args) {
        number_of_recent_cells rc = new number_of_recent_cells();
        System.out.println(rc.ping(1));     // Output: 1
        System.out.println(rc.ping(100));   // Output: 2
        System.out.println(rc.ping(3001));  // Output: 3
        System.out.println(rc.ping(3002));  // Output: 3
    }
}
