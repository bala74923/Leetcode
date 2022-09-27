package AfterContest;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
    }
    List<List<String>> list;
    boolean[] v,r1,r2;
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        v = new boolean[n];
        r1 = new boolean[2*n];
        r2 = new boolean[2*n];
        char[][] matrix = new char[n][n];
        for(int i=0;i<n;i++){
            matrix[i]= ".".toCharArray();
        }
        check(0,matrix);
        return list;
    }
    void check(int currRow,char[][] matrix){
        int n = matrix.length;
        if(currRow== matrix.length){
            list.add(getMatrix(matrix));
            return;
        }
        for(int col=0;col<matrix[0].length;col++){
            if(!v[col]&&!r1[currRow+col]&&!r2[col-currRow+n]){
                matrix[currRow][col]='Q';
                v[col]= r1[currRow+col] = r2[col-currRow+n] = true;
                check(currRow+1,matrix);
                matrix[currRow][col]='.';
                v[col]= r1[currRow+col] = r2[col-currRow+n] = false;
            }
        }

    }

    List<String> getMatrix(char[][] matrix){
        List<String> ans = new ArrayList<>();
        for(char[] c:matrix){
            ans.add(new String(c));
        }
        return ans;
    }
}
