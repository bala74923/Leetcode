class Solution {
    int[][] mat;
    int N,count;
    boolean[] c,d1,d2;
    public int totalNQueens(int n) {
        N= n;
        count = 0;
        mat = new int[N][N];
        c= new boolean[N];
        d1= new boolean[2*N];
        d2= new boolean[2*N];
        rec(0);
        return count;
    }
     void rec(int curr){
        if(curr==N){
            count++;
            return ;
        }
        for(int col=0;col<N;col++){
            if(!isAttack(curr,col)){
                c[col] = d1[col+curr] = d2[col-curr+N] = true;
                rec(curr+1);
                c[col] = d1[col+curr] = d2[col-curr+N] = false;
            }
        }
    }
     boolean isAttack(int i,int j){
        return c[j]||d1[i+j]||d2[j-i+N];
    }
}