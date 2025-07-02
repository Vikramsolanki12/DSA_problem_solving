public class reverse_string {
    public static void reverse_string(String s){
        String reversed="";
        for(int i= s.length()-1;i>=0;i--){
            reversed += s.charAt(i);
        }
        System.out.println(reversed);

    }

    public static void main(String[] args) {
        String s="vikram";
        reverse_string(s);
    }
}
