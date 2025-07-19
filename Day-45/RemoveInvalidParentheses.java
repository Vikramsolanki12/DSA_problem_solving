import java.util.*;

public class RemoveInvalidParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String next = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        return result;
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            else if (ch == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String input = "()())()";
        List<String> res = removeInvalidParentheses(input);
        System.out.println(res);  // Output: ["(())()", "()()()"]
    }
}
