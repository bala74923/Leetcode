class Solution {
    boolean[][] row, col, diag;
    boolean done;
    List<int[]> empty;
    public void solveSudoku(char[][] board) {
        col = new boolean[10][10];
        row = new boolean[10][10];
        diag = new boolean[10][10];
        empty = new ArrayList<>();
        for (int i = 0, i1 = 0; i < 9; i ++, i1++) {
            for (int j = 0, j1 = 0; j < 9; j ++, j1++) {
                int diag_no = (i / 3) * 3 + (j / 3);
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    row[i][val] = col[j][val] = diag[diag_no][val] = true;
                }else empty.add(new int[]{i,j,diag_no});
            }
        }
        //System.out.println(Arrays.deepToString(row));
        rec(0,empty,board);
    }
     boolean rec(int ind,List<int[]> list,char[][] board){
        if(ind==list.size()) return true;
        for(int i=1;i<=9;i++){
            char c = (char)(i+'0');
            int x = list.get(ind)[0],y = list.get(ind)[1],dno = list.get(ind)[2];
            // check possible or not
            if(row[x][i]||col[y][i]||diag[dno][i]) continue; // already exist
            row[x][i] =col[y][i] = diag[dno][i] = true;
            board[x][y] = c;
            if(rec(ind+1,empty,board)) return true;
            board[x][y] = '.';
            row[x][i] =col[y][i] = diag[dno][i] = false;
        }
        return false;
    }
    static void print(char[][] board) {
        for (char[] b : board) {
            System.out.println(new String(b));
        }
        System.out.println("done");
    }
    
    
}
