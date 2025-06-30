public class brute_force {
    public static void main(String[] args) {
        int[] A= {2,5,9,1,3,7,6};
        int max = A[0];
        int min = A[0];

        for(int i=1 ; i<A.length ;i++){
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
        }
        System.out.println("minimum:"+ min);
        System.out.println("maximum:"+ max);
    }
}
