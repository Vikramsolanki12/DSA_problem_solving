public class basic_calculator_II {
        public static int calculate(String s) {
            if (s == null || s.isEmpty()) return 0;

            int result = 0;
            int lastNumber = 0;
            int currentNumber = 0;
            char operation = '+';
            int len = s.length();

            for (int i = 0; i < len; i++) {
                char currentChar = s.charAt(i);

                if (Character.isDigit(currentChar)) {
                    currentNumber = currentNumber * 10 + (currentChar - '0');
                }

                if ((!Character.isDigit(currentChar) && currentChar != ' ') || i == len - 1) {
                    switch (operation) {
                        case '+':
                            result += lastNumber;
                            lastNumber = currentNumber;
                            break;
                        case '-':
                            result += lastNumber;
                            lastNumber = -currentNumber;
                            break;
                        case '*':
                            lastNumber = lastNumber * currentNumber;
                            break;
                        case '/':
                            lastNumber = lastNumber / currentNumber;
                            break;
                    }
                    operation = currentChar;
                    currentNumber = 0;
                }
            }

            result += lastNumber;
            return result;
        }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3/2"));

    }

}
