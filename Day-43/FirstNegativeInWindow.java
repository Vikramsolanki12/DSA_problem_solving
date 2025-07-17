import java.util.*;

public class FirstNegativeInWindow {
    public static List<Integer> firstNegative(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                deque.addLast(i);
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                if (!deque.isEmpty()) {
                    result.add(arr[deque.peekFirst()]);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, 15, 30, 16, 28};
        int k = 3;
        List<Integer> res = firstNegative(arr, k);
        System.out.println(res); // Output: [-1, -1, -7, 0, 0, 0]
    }
}
