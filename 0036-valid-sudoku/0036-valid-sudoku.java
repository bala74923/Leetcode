class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[10],col  = new int[10];
        // i-> represents row/col, row[i] represents bit 
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                int sub = 0;
                for(int i1=0;i1<3;i1++){
                    for(int j1=0;j1<3;j1++){
                        char curr=  board[i+i1][j+j1];
                        if(curr=='.') continue;
                        int val = curr-'0';
                        if(!has(row[i1+i],val) && !has(col[j1+j],val) && !has(sub,val)){
                            row[i1+i] = set(row[i1+i],val);
                            col[j1+j] =set(col[j1+j],val);
                            sub = set(sub,val);
                        }else return false;
                    }
                }
            }
        }
        return true;
    }
    int set(int hash,int num){
        return hash|(1<<num);
    }
    boolean has(int hash,int num){
        return (hash&(1<<num))!=0;
    }
}