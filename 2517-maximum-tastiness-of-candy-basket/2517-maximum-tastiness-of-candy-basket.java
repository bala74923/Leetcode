class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int lo = 0, hi = (int)1e9;
        int res = -1;
        while(lo<=hi){
            int mid = (lo+hi)>>1;
            if(possible(price, k, mid)){
                res = mid;
                lo = mid+1;
            }else hi= mid-1;
        }
        return res;
    }
    boolean possible(int[] price,int k,int diff){
        int count = 1,last = price[0];
        for(int i=1; i< price.length;i++){
            if(last+diff<= price[i]){
                last = price[i];
                count++;
                if(count==k) return true;
            }
        }
        return false;
    }
}