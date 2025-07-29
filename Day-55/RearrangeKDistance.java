import java.util.*;

public class RearrangeKDistance {
    public static String rearrangeString(String s, int k) {
        if (k == 0) return s;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray())
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());

        Queue<Character> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            result.append(current);
            freqMap.put(current, freqMap.get(current) - 1);
            waitQueue.offer(current);

            if (waitQueue.size() >= k) {
                char front = waitQueue.poll();
                if (freqMap.get(front) > 0) {
                    maxHeap.offer(front);
                }
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aabbcc", 3));
        System.out.println(rearrangeString("aaabc", 3));
    }
}
