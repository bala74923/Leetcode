class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length,n= matrix[0].length;
        int maxi =0;
        for(int scol=0;scol<n;scol++){
            int currMax = 0;
            boolean[] b = new boolean[m];
            Arrays.fill(b,true);
            for(int ecol=scol;ecol<n;ecol++){
                for(int r=0;r<m;r++){
                    b[r] = b[r] && (matrix[r][ecol]=='1');
                }
                int i1=0;
                while(i1<m){
                    int count=0;
                    while(i1<m && b[i1]){
                        i1++;
                        count++; 
                    }
                    maxi = Math.max(maxi,count*(ecol-scol+1));
                    i1++;
                }
                
            }
        }
        return maxi;
    }
}