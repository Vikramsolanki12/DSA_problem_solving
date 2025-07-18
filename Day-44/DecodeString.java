import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String currentStr = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(k);
                strStack.push(currentStr);
                k = 0;
                currentStr = "";
            } else if (ch == ']') {
                int times = numStack.pop();
                StringBuilder sb = new StringBuilder(strStack.pop());
                for (int i = 0; i < times; i++) {
                    sb.append(currentStr);
                }
                currentStr = sb.toString();
            } else {
                currentStr += ch;
            }
        }

        return currentStr;
    }

    public static void main(String[] args) {
        String encoded = "3[a2[c]]";
        System.out.println(decodeString(encoded)); // Output: accaccacc
    }
}
