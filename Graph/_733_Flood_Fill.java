package Graph;

public class _733_Flood_Fill {

    //best
    int[][] solve(int[][] image, int sr, int sc, int color) {
        if(color!=image[sr][sc])
            dfs(sr,sc,image[sr][sc],color,image);
        return image;
    }
    void dfs(int i,int j,int color,int newColor,int[][] image){
        if(i<0 || j<0|| i>=image.length || j>=image[0].length || image[i][j]!=color)
            return ;
        image[i][j] = newColor;
        dfs(i-1,j,color,newColor,image);
        dfs(i,j+1,color,newColor,image);
        dfs(i+1,j,color,newColor,image);
        dfs(i,j-1,color,newColor,image);
    }


    class solution2{
         int[][] solve(int[][] image, int sr, int sc, int color) {
             dfs(sr,sc,image[sr][sc],color,image, new boolean[image.length][image[0].length]);
             return image;
         }
         void dfs(int i,int j,int color,int newColor,int[][] image,boolean[][] visited){
             if(i<0 || j<0|| i>=image.length || j>=image[0].length || image[i][j]!=color)
                 return ;
             if(visited[i][j]) return ;

             image[i][j] = newColor;
             visited[i][j] = true;
             dfs(i-1,j,color,newColor,image,visited);
             dfs(i,j+1,color,newColor,image,visited);
             dfs(i+1,j,color,newColor,image,visited);
             dfs(i,j-1,color,newColor,image,visited);
         }
     }
    class solution1{
        int[][] solve(int[][] image, int sr, int sc, int color) {
            dfs(sr,sc,image[sr][sc],color,image);
            for(int i=0;i<image.length;i++){
                for(int j=0;j<image[i].length;j++){
                    if(image[i][j]==-1)
                        image[i][j] = color;
                }
            }
            return image;
        }
        void dfs(int i,int j,int color,int newColor,int[][] image){
            if(i<0 || j<0|| i>=image.length || j>=image[0].length || image[i][j]!=color)
                return ;
            image[i][j] = -1;
            dfs(i-1,j,color,newColor,image);
            dfs(i,j+1,color,newColor,image);
            dfs(i+1,j,color,newColor,image);
            dfs(i,j-1,color,newColor,image);
        }
    }
}
