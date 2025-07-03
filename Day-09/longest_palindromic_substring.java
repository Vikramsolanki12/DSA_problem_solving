public class longest_palindromic_substring {
        public static String longestPalindromic(String str) {
            if (str.length() <= 1) return str;

            String LPS = "";

            for (int i = 0; i < str.length(); i++) {
                int low = i - 1;
                int high = i + 1;

                while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                    low--;
                    high++;
                }

                String palindrome = str.substring(low + 1, high);
                if (palindrome.length() > LPS.length()) {
                    LPS = palindrome;
                }

                low = i;
                high = i + 1;

                while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                    low--;
                    high++;
                }

                palindrome = str.substring(low + 1, high);
                if (palindrome.length() > LPS.length()) {
                    LPS = palindrome;
                }
            }

            return LPS;
        }

        public static void main(String[] args) {
            System.out.println(longestPalindromic("babad"));
            System.out.println(longestPalindromic("cbbd"));
        }


}
