import java.util.Arrays;

public class two_sum {
    public static boolean hasTwoSumSorted(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                System.out.println("Found pair: " + arr[start] + " + " + arr[end] + " = " + target);
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,8,3,9,12,6};
        int target =9;
        Arrays.sort(arr);
        boolean res=hasTwoSumSorted(arr,target);
        System.out.println(res);
    }
}
