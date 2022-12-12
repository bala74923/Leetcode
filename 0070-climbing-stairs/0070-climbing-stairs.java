class Solution {
    public int climbStairs(int n) {
        int prepre = 1,pre = 1;
        for(int ind=2;ind<=n;ind++){
            int curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}