class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int curr = 0;
                double s  = slope(i,j,points);
                for(int k=0;k<n;k++){
                    if(slope(i,k,points) == s){
                        curr++;
                    }
                }
                res = Math.max(res, curr+1);
            }
        }
        return res;
    }
    double slope(int i,int j,int[][] points){
        //{xi,yi}
        return (double)(points[i][0]-points[j][0])/(points[i][1]-points[j][1]);
    }
}