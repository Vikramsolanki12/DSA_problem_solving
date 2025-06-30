import java.util.Arrays;

public class contains_duplicate {
    public static void main(String[] args) {
        int[] arr= {2,5,9,1,5,7,6};
        int x=0;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]== arr[i-1]){
                x=1;
            }

        }
        if(x==1){
            System.out.println("contains Duplicate");
        }else {
            System.out.println("not contains duplicate");
        }
    }
}
