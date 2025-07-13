import java.util.Stack;

public class reversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int applyOperator(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"}; // (2 + 1) * 3 = 9
        System.out.println("Result: " + evalRPN(tokens)); // 9

        String[] tokens2 = {"4", "13", "5", "/", "+"}; // 4 + (13 / 5) = 6
        System.out.println("Result: " + evalRPN(tokens2)); // 6
    }
}
