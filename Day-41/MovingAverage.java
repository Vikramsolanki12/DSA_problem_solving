import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> window;
    private int maxSize;
    private double sum;

    public MovingAverage(int size) {
        window = new LinkedList<>();
        maxSize = size;
        sum = 0.0;
    }

    public double next(int val) {
        if (window.size() == maxSize) {
            sum -= window.poll();
        }
        window.add(val);
        sum += val;
        return sum / window.size();
    }

    public static void main(String[] args) {
        MovingAverage mv = new MovingAverage(3);
        System.out.println(mv.next(1)); // 1.0
        System.out.println(mv.next(10)); // (1+10)/2 = 5.5
        System.out.println(mv.next(3)); // (1+10+3)/3 = 4.666...
        System.out.println(mv.next(5)); // (10+3+5)/3 = 6.0
    }
}
