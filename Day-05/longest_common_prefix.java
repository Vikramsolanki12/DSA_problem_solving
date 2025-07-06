public class longest_common_prefix {
    public static String longestCommonPrefix(String[] strs){
        if(strs==null || strs.length==0){
            return "";
        }
        String prefix=strs[0];

        for(int i=0;i<strs.length;i++){
            while (strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        String res =longestCommonPrefix(strs);
        System.out.println(res);
    }
}
