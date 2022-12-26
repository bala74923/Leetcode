class Solution {
    int k;
    int mod=  (int)(Math.pow(10,9))+7;
    int[][] mem;
    public int countPartitions(int[] nums, int k) {
        this.k = k;
        int N = nums.length;
        long tot =0;
        for(int n: nums) tot += n;
        if(2*k>tot) return 0;
        mem=  new int[N][k];
        for(int[] m1: mem)
            Arrays.fill(m1,-1);
        
        int invalid = f(0, 0 , nums);
        long res = mpow(2,N)- (2*invalid);
        return (int)((res%mod+mod)%mod);
        //return (int)(Math.max(res,0)%mod);
    }
    long mpow(int a,int b){
        if(b==0) return 1;
        long val = mpow(a,b/2)%mod;
        return (val*val*(b%2==1?a:1))%mod;
    }
    int f(int ind,int curr , int[]  nums){
        if(ind==nums.length)
            return 1;
        if(mem[ind][curr]!=-1)
            return mem[ind][curr];
        int pick = 0 ;
        if(curr+nums[ind]< k){
            pick = f(ind+1, curr+nums[ind], nums)%mod;
        }
        int not_pick = f(ind+1, curr, nums)%mod;
        return mem[ind][curr] = (pick+not_pick)%mod;
    }
}