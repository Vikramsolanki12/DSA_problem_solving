public class implement_strStr {
        public static int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();

            if (n == 0) return 0;

            for (int i = 0; i <= m - n; i++) {
                if (haystack.substring(i, i + n).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            String haystack = "leetcode";
            String needle = "code";
            System.out.println("Index: " + strStr(haystack, needle));
        }
}
