public class set_matrix_zeroes {
    public static void set_zeroes(int[][] matrix){
        boolean firstRow=false, firsCol=false;

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) firstRow=true;
                    if(j==0) firsCol=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1 ; i<matrix.length;i++){
            for (int j=1 ; j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRow){
            for (int j=0;j< matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }

        if(firsCol){
            for (int j=0;j< matrix.length;j++){
                matrix[j][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,1,1},
                {1,0,0},
                {1,1,1}
        };
        set_zeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
