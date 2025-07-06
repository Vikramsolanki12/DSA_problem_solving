public class is_array_sorted {
    public static void main(String[] args) {
        int[] arr= {2,5,9,10,15};
        int x=0;

        for(int i=1; i<arr.length;i++) {
            if (arr[i] < arr[i - 1]) {
                x = 1;
            }
        }

        if(x==0){
            System.out.println("sorted");
        }else {
            System.out.println("not sorted");
        }
    }
}
