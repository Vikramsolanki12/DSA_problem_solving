public class remove_duplicate {
    public static int remove_duplicate(int[]arr){
        if(arr.length==0) return 0;

        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr= {2,5,9,2,5,7,6};

        int res=remove_duplicate(arr);
        System.out.println(res);
    }
}
