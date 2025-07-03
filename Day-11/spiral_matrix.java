public class spiral_matrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int rowBegin=0;
        int colBegin=0;
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int j=colBegin;j<=colEnd;j++){
                System.out.print(matrix[rowBegin][j]+" ");
            }
            rowBegin++;

            for(int j=rowBegin;j<=rowEnd;j++){
                System.out.print(matrix[j][colEnd]+" ");
            }
            colEnd--;

            if(rowBegin<=rowEnd){
                for (int j=colEnd;j>=colBegin;j--){
                    System.out.print(matrix[rowEnd][j]+" ");
                }
            }
            rowEnd--;

            if(colBegin<=colEnd){
                for (int j=rowEnd;j>=rowBegin;j--){
                    System.out.print(matrix[j][colBegin]+" ");
                }
            }
            colBegin++;
        }
    }
}
