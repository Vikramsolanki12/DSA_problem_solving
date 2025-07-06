public class basic_calculator {

        public static int calculate(String s) {
            return helper(s);
        }

        public static int helper(String s) {
            int index=0;
            int num = 0;
            int result = 0;
            int sign = 1;

            while (index < s.length()) {
                char c = s.charAt(index);

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else if (c == '+') {
                    result += sign * num;
                    num = 0;
                    sign = 1;
                } else if (c == '-') {
                    result += sign * num;
                    num = 0;
                    sign = -1;
                } else if (c == '(') {
                    index++;
                    num = helper(s);
                } else if (c == ')') {
                    result += sign * num;
                    return result;
                }
                index++;
            }

            result += sign * num;
            return result;
        }

    public static void main(String[] args) {
        System.out.println(calculate("2+3"));
    }

}
