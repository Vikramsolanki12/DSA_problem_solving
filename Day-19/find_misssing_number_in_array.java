public class find_misssing_number_in_array {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;

        for (int num : nums) {
            total -= num;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing Number: " + missingNumber(nums));
    }
}
