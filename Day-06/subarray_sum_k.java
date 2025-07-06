import java.util.HashMap;

public class subarray_sum_k {
    public static int subarraySumEqual(int[] nums, int k){
        int count=0;
        int sum=0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int num : nums){
            sum +=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={1,1,3,1};
        int k=3;
        int res=subarraySumEqual(nums,k);
        System.out.println(res);
    }
}
