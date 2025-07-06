public class valid_palindrome {
    public static boolean is_valid_palindrome(String s){
        int start =0;
        int end=s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "carac";
        boolean res=is_valid_palindrome(input);
        System.out.println(res);
    }
}
