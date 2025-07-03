import java.util.HashSet;
import java.util.Set;

public class longest_substring_without_repeating_char {
    public static int LengthOfLongestSubString(String s){
        Set<Character> charSet= new HashSet<>();
        int maxLength=0;
        int left=0;

        for(int right=0;right<s.length();right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(LengthOfLongestSubString(s));
    }
}
