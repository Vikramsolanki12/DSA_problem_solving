public class string_to_integer {
    public static int StringToInteger(String s){
        s = s.trim();
        if (s.isEmpty()) return 0;

        long num = 0;
        int i = 0;
        int sign = 1;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }


        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }

    public static void main(String[] args) {
        String s="-042";
        System.out.println(StringToInteger(s));
    }
}
