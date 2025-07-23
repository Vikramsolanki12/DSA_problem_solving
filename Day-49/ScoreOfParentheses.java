import java.util.Stack;

public class ScoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();
                int outerScore = stack.pop();
                int newScore = outerScore + Math.max(2 * innerScore, 1);
                stack.push(newScore);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));         // 1
        System.out.println(scoreOfParentheses("(())"));       // 2
        System.out.println(scoreOfParentheses("()()"));       // 2
        System.out.println(scoreOfParentheses("(()(()))"));   // 6
    }
}
