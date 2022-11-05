class Solution {
    public int findDuplicate(int[] nums) {
        return solve(nums);
    }
    int solve(int[] nums){
       for(int i=0;i<nums.length;i++){
           int val = Math.abs(nums[i]);
           nums[val]*=-1;
           if(nums[val]>0){
               return val;
           }
       }
        return -1;
    }
}