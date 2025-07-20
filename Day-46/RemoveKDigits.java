import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString().isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // "1219"
        System.out.println(removeKdigits("10200", 1));   // "200"
        System.out.println(removeKdigits("10", 2));      // "0"
    }
}
