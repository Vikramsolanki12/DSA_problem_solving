import java.util.Arrays;

public class move_zeroes {
    public static void moveZeroes(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[start] = arr[i];
                start++;
            }
        }
        while (start < arr.length) {
            arr[start] = 0;
            start++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,5,0,3,0,12,6};
        moveZeroes(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
