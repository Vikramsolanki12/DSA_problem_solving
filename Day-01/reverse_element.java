public class reverse_element {
    public static void main(String[] args) {
        int[] arr= {2,5,9,1,3,7,6};

        int start=0;
        int end = arr.length-1;

        while(start<end){
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}
