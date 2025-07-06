import java.util.HashMap;

public class roman_to_integer {
        public static int romanToInt(String s) {
            HashMap<Character, Integer> roman = new HashMap<>();
            roman.put('I', 1);
            roman.put('V', 5);
            roman.put('X', 10);
            roman.put('L', 50);
            roman.put('C', 100);
            roman.put('D', 500);
            roman.put('M', 1000);

            int total = 0;
            int prev = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                int curr = roman.get(s.charAt(i));

                if (curr < prev)
                    total -= curr;
                else
                    total += curr;
                prev = curr;
            }
            return total;
        }

        public static void main(String[] args) {
            String roman = "MCMXCIV";
            System.out.println("Integer: " + romanToInt(roman));
        }
}
