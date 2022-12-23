class Solution {
    int R,C;
    int[][] dirs = {{-1,0},{0,-1}};
    int[] dsuf;
    int[] size;
    public int largestIsland(int[][] grid) {
        R = grid.length; C = grid[0].length;
        dsuf = new int[R*C];
        Arrays.fill(dsuf,-1);
        int res = 0;
        size = new int[R*C];
        // create components
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1){ // land connect it to adj lands
                    size[index(i,j)] = 1; // as it is land
                    int curr_size = 1;
                    // connect all adj island to this land
                    for(int[] dir: dirs){
                        int x = dir[0]+i, y = dir[1]+j;
                        if(x>-1 && y>-1 && x<R && y<C && grid[x][y]==1){
                            // find parent of this island and union
                            int pa = index(i,j);
                            int pb = find(index(x,y),true);
                            
                            if(pa==pb) continue;
                            else{
                                // pa is the only parent here
                                    dsuf[pb] = pa;
                                    size[pa]+=size[pb];
                            }
                        }
                    }
                    res = Math.max(res, size[ index(i,j) ]);
                }
            }
        }
        //System.out.println(res+"=");
       int[][] dirs1= {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==0){
                    size[index(i,j)] = 1; // as it is land
                    Stack<Integer> lead = new Stack<>();
                    int curr_size = 1;
                    // connect all adj island to this land
                    for(int[] dir: dirs1){
                        int x = dir[0]+i, y = dir[1]+j;
                        if(x>-1 && y>-1 && x<R && y<C && grid[x][y]==1){
                            // find parent of this island and union
                            int pa = index(i,j);
                            int pb = find(index(x,y),false);
                            //System.out.printf("%d = [%d,%d] , %d=[%d,%d]\n",pa,i,j, pb,x,y);
                            
                            if(pa==pb) continue;
                            else{
                                // pa is the only parent here
                                    lead.push(pb);
                                   dsuf[pb] = pa;
                                   curr_size += size[pb];
                                //System.out.println(pa+" ,"+pb +" are different sets");
                            }
                        }
                    }
                    size[index(i,j)] = 0;
                    while(!lead.isEmpty()) dsuf[lead.pop()] = -1; // setting all the leads again to zero
                    //System.out.println(i+" "+j+","+curr_size+" done");
                    res = Math.max(res, curr_size);
                }
            }
        }
        return res;
    }
        
    int find(int ind,boolean pc){
        if(dsuf[ind]==-1 )
            return ind;
        int val = find(dsuf[ind],pc);
        if(pc) dsuf[ind] = val; 
        return val;
    }
    int index(int i,int j){
        return i*C+j;
    }
}