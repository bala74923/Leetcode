class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int start = intervals[0][0],end=  intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            int currs = intervals[i][0],curre = intervals[i][1];
            if(end<currs){
                list.add(new int[]{start,end});
                start = currs;
                end = curre;
            }else{
                end = Math.max(end,curre);
            }
        }
        list.add(new int[]{start,end});
        
        
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
}