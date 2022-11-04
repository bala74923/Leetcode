class Solution {
    public void rotate(int[][] arr) {
       int N = arr.length;
       int lo = 0, hi = N-1;
       while(lo<hi){
           for(int i=0;i<(hi-lo);i++){
               int temp = arr[lo][lo+i];
               arr[lo][lo+i] = arr[hi-i][lo];
               arr[hi-i][lo] = arr[hi][hi-i];
               arr[hi][hi-i] = arr[lo+i][hi];
               arr[lo+i][hi] = temp;
           }
           lo++;hi--;
       }
    }
}