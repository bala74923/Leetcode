class Solution {
    List<List<String>> list;
    boolean[] bc,bd1,bd2;
    public List<List<String>> solveNQueens(int n) {      
        int r =n,c = n;
        list=  new ArrayList<>();
        int[][] mat  = new int[r][c];
        bc = new boolean[c];
        bd1 = new boolean[2*n];
        bd2 = new boolean[2*n];
        rec(0,n,mat);
        return list;
    }
    void rec(int currRow,int n,int[][] mat){
        if(currRow==n){
            list.add(print(mat));
            return ;
        }
        for(int col=0;col<n;col++){
            if(!isAttack(currRow,col,mat)){
                mat[currRow][col]=1;
                bc[col]=bd1[currRow+col]=bd2[col-currRow+n] = true;

                rec(currRow+1,n,mat);
                
                mat[currRow][col]=0;
                bc[col]=bd1[currRow+col]=bd2[col-currRow+n] = false;
            }
        }
    }

    boolean isAttack(int i,int j,int[][] mat){
        //search in 90,45,110 degrees
        // search in same col
        // for(int row=i;row>=0;row--){
        //     if(mat[row][j]==1) return true;
        // }
        // search in left diagonal
        // for(int row=i,col=j;row>-1 && col>-1 ;row--,col--){
        //     if(mat[row][col]==1) return true;
        // }
        // // search in right diagonal
        // for(int row=i,col=j;row>-1 && col<mat[0].length;row--,col++){
        //     if(mat[row][col]==1) return true;
        // }
        // return false;
        return bc[j]||bd1[i+j]||bd2[j-i+mat.length];
    }
    static List<String> print(int[][] mat){
        List<String> list = new ArrayList<>();
        for(int[] arr: mat){
            String s = "";
            for(int val: arr){
                s+= val==1?"Q":".";
            }
            list.add(s);
        }
        return list;
    }
}