class Solution {
    char[][] board;
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    String word;
    public boolean exist(char[][] board, String word) {
      this.board= board;
      this.word = word;
        int m = board.length, n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rec(i,j,0)) return true;
            }
        }
        return false;
    }
    boolean  rec(int i,int j,int index){
        if(index==word.length()) return true;
        if(i<0 || j<0|| i>=board.length ||j>=board[0].length || word.charAt(index)!=board[i][j]) 
            return false;
        boolean res = false;
        //visit any of the four side
        for(int[] dir: dirs){
            int x = i+dir[0],y =j+dir[1];
            char temp = board[i][j];
            board[i][j] = '$';// it cannot be matched with none so visiting this cell again gives us false as result
            res = res|| rec(x,y,index+1);
            board[i][j] = temp;
        }
        return res;
    }
    
}