public class sort_colors {
    public static void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static void sort_colors(int[] arr) {
       int start =0;
       int mid=0;
       int end=arr.length-1;
       while (mid<=end){
           switch (arr[mid]){
               case 0:
                   swap(arr,start,mid);
                   mid++;
                   start++;
                   break;
               case 1:
                   mid++;
                   break;
               case 2:
                   swap(arr,mid,end);
                   end--;
                   break;
           }
       }
    }
    public static void main(String[] args) {
        int[] arr = {2,0,0,2,0,1,1};
        sort_colors(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
