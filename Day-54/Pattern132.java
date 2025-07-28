import java.util.*;

public class Pattern132 {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));     // false
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));     // true
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));    // true
    }
}
