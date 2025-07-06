public class permutation_in_string {
    public static boolean isFreqSame(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                    return false;
            }
        }
        return true;
    }

    public static boolean permutationInString(String s1, String s2){
        int[] freq=new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int windSize=s1.length();

        for(int i=0;i<s2.length();i++){
            int windIdx=0;
            int idx=i;
            int[] windFreq=new int[26];

            while (windIdx<windSize && idx<s2.length()){
                windFreq[s2.charAt(idx)-'a']++;
                windIdx++;
                idx++;
            }
            if(isFreqSame(freq,windFreq)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(permutationInString("ab", "eidbaooo")); // true
        System.out.println(permutationInString("ab", "eidboaoo")); // false
    }

}
