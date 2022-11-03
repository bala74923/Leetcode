class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int rz= matrix[0][0],cz = rz;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i!=0) matrix[i][0]= 0;
                    else rz =0;
                    if(j!=0) matrix[0][j]= 0;
                    else cz = 0;
                }
            }
        }
      //  System.out.println(rz);
     //   System.out.println(Arrays.deepToString(matrix));
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==0 && rz==0) matrix[i][j]=0; 
                else if(i!=0 && matrix[i][0]==0) matrix[i][j] = 0;
                if(j==0 && cz==0) matrix[i][j] =0;
                else if(j!=0 && matrix[0][j]==0) matrix[i][j] = 0;
            }
        }
        
    }
}