import java.util.*;

public class BasicCalculatorII {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                switch (sign) {
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack) result += val;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));     // 7
        System.out.println(calculate(" 3/2 "));     // 1
        System.out.println(calculate(" 3+5 / 2 ")); // 5
    }
}
