public class valid_anagram {
    public static boolean is_valid_angaram(String s, String t){
        int s_length= s.length();
        int t_length = t.length();

        if(s_length != t_length) return false;
        else {
            int count[] = new int[26];
            for(int i=0;i<s_length;i++){
                count[s.charAt(i)-'a']++;
            }
            for(int j=0;j<t_length;j++){
                count[t.charAt(j)-'a']--;
            }
            for(int k=0;k<count.length;k++){
                if(count[k]!=0){
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";

        boolean res = is_valid_angaram(s,t);
        System.out.println(res);

        String x="cat";
        String y="mat";

        boolean res2 = is_valid_angaram(x,y);
        System.out.println(res2);

    }
}
