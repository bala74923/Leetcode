package DC;

public class rotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    }    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
         for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                  int temp = matrix[i][j];
                  matrix[i][j] = matrix[j][n-i-1];
                  matrix[j][n-i-1] = matrix[n-1-i][n-1-j];
                  matrix[n-1-i][n-1-j]= matrix[n-1-j][i];
                  matrix[n-1-j][i]  = temp;
            }
         }
    }
}
