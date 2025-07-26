import java.util.*;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c = 'a'; c <= 'z'; c++) {
            if (freq[c - 'a'] > 0)
                maxHeap.offer(new int[]{c, freq[c - 'a']});
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            sb.append((char) first[0]);
            sb.append((char) second[0]);

            if (--first[1] > 0) maxHeap.offer(first);
            if (--second[1] > 0) maxHeap.offer(second);
        }

        if (!maxHeap.isEmpty()) {
            int[] last = maxHeap.poll();
            if (last[1] > 1) return "";
            sb.append((char) last[0]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));    // "aba"
        System.out.println(reorganizeString("aaab"));   // ""
    }
}
