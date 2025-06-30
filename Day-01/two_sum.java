import java.util.HashMap;
import java.util.Map;

public class two_sum {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer,Integer> numMap= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            int complement=target-current;

            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement),i};
            }
            numMap.put(current,i);
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int[] arr={3,2,6,9,5,8,12};
        int[] ans = new two_sum(arr,11);
    }
}
