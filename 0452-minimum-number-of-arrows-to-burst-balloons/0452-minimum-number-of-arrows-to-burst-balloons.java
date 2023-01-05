class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points ,(a,b)-> a[0]<b[0]?-1:(a[0]==b[0]?0:1) );
        int new_start = points[0][0], new_end = points[0][1];
        int res = 0;
        for(int i=1;i<points.length;i++){
            int s = points[i][0], e = points[i][1];
            if(s<=new_end){
                System.out.println(i+" ns = "+new_start+" ne ="+new_end);
                new_start = Math.min(new_start,s);
                new_end = Math.min(new_end, e);
            }else{
                res++;
                new_start = s;
                new_end = e;
            }
        }
        return res+1;
    }
}