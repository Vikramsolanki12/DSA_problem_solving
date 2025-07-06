public class longest_palindromic_subsequence {
    public  static int lcs(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static int longestPalindromicSubsequence(String s){
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("bbbab"));
        System.out.println(longestPalindromicSubsequence("cbbd"));

    }
}
