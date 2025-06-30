public class maximum_avg_sub {
    public static double max_avg_sub(int[] arr,int k) {
        int sum =0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }

        int start=0;
        int end=k;
        int maxSum=sum;
        while (end<arr.length){
            sum-=arr[start];
            start++;

            sum+=arr[end];
            end++;

            maxSum=Math.max(sum,maxSum);
        }
        return (double) maxSum/k;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,9,3,5,12,6};
        double res=max_avg_sub(arr,4);
        System.out.println(res);

    }
}
