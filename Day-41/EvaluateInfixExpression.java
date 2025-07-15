import java.util.*;

public class EvaluateInfixExpression {

    public static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return 0;
    }

    public static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static int evaluate(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isWhitespace(ch)) continue;

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                values.push(num);
                i--;
            }

            else if (ch == '(') {
                ops.push(ch);
            }

            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    int val2 = values.pop();
                    int val1 = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(val1, val2, op));
                }
                ops.pop();
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    int val2 = values.pop();
                    int val1 = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(val1, val2, op));
                }
                ops.push(ch);
            }
        }


        while (!ops.isEmpty()) {
            int val2 = values.pop();
            int val1 = values.pop();
            char op = ops.pop();
            values.push(applyOp(val1, val2, op));
        }

        return values.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String expr = sc.nextLine();

        try {
            int result = evaluate(expr);
            System.out.println("Result = " + result);
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
