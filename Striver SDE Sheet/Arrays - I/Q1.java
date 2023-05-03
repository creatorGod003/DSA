import java.util.Arrays;
import java.util.Scanner;

class Q1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        Q1 q = new Q1();

        q.setZeroes(matrix);

        for(int[] arr: matrix){
            System.out.println(Arrays.toString(arr));
        }

        sc.close();
        
    }

    public void setZeroes(int[][] matrix) {
        
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }

            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){

                    if(rows[i] == 1){
                        setRowZero(matrix, i);
                        rows[i] = 0;
                    }

                    if(cols[j] == 1){
                        setColumnZero(matrix, j);
                        cols[j] = 0;
                    }

                }

            }
        }
        
    }

    public void setRowZero(int[][] matrix, int i){
        for(int k=0;k<matrix[i].length;k++){
            matrix[i][k] = 0; 
        }
    }

    public void setColumnZero(int[][] matrix, int j){
        for(int k = 0;k<matrix.length;k++){
            matrix[k][j] = 0;
        }
    }

}