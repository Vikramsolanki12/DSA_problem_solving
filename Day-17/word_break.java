import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_break {
    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordSet= new HashSet<>(wordDict);

        int maxLen=0;
        for(String word: wordDict){
            maxLen=Math.max(maxLen,word.length());
        }
        int n= s.length();
        boolean[] dp=new boolean[n+1];

        dp[0]=true;

        for (int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> wordDict= Arrays.asList("cats","dog","sand","and","cat");
        String s="catsandog";

        System.out.println(wordBreak(s,wordDict));
    }
}
