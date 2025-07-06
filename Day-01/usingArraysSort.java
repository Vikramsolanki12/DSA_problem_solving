import java.util.*;

public class usingArraysSort {
    public static void main(String[] args) {
        int[] arr = {13,2,4,25,18,34,3};
        Arrays.sort(arr);

        int min=arr[0];
        int max=arr[arr.length-1];

        System.out.println("minimum:"+min);
        System.out.println("maximum:"+ max);
    }
}
