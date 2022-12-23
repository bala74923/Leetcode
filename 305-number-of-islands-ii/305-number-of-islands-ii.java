// water will have -1,-1 , land leader have same i,j, normal land have parentI,preanJ
class Solution {
    int[][] dirs= {{-1,0},{0,-1},{0,1},{1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][][] mat = new int[m][n][2];
        
        for(int[][] mat1: mat){
            for(int[] mat11: mat1){
                Arrays.fill(mat11,-1);
            }
        }
        int count = 0;
        List<Integer> soln = new ArrayList<>();
        for(int[] e: positions){
            int x=e[0], y= e[1];
            //if already land skip
            if(mat[x][y][0]!=-1) {// already land
                soln.add(count);
                continue;
            }
            mat[x][y][0] = x;mat[x][y][1] = y; // making it as land or leader of single comp
            count++;
            List<int[]> adjLands= new ArrayList<>();
            for(int[] dir: dirs){
                int i = x+dir[0], j = y+dir[1];
                if(i>-1 && j>-1 && i<m && j<n && mat[i][j][0]!=-1 && mat[i][j][1]!=-1){
                    // land
                    // find abs parent and add
                    int[] sub = find(mat, i,j);
                    int pi = sub[0], pj= sub[1];
                    if(union(mat, x,y, pi,pj)){ // two islands are made as one
                        count--;
                    }
                }
            }
            soln.add(count);
            // connect all the lands now
            
        }
        return soln;
    }
    boolean union(int[][][] dsuf, int pai,int paj,int pbi,int pbj){
        if(pai==pbi && paj == pbj) return false; // already connected
        // pa is always going to be parent
        dsuf[pbi][pbj][0] = pai;
        dsuf[pbi][pbj][1] = paj;
        return true;
    }
    static int[] find(int[][][] mat, int i,int j){
        if(mat[i][j][0]==i && mat[i][j][1] == j)
            return new int[]{i,j};
        return mat[i][j] = find( mat, mat[i][j][0],mat[i][j][1]);
    }
}