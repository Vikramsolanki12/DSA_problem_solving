import java.util.Arrays;

public class binary_search {
    public static int binary_search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr={12,25,36,42,50,62};
        System.out.println(binary_search(arr,42));

    }
}
