class Solution {
    public void sortColors(int[] nums) {
       int N = nums.length;
        int lo = 0,hi = N-1,mid=0;
        while(mid<=hi){
            if(nums[mid]==0){
                // swap it to left border
                swap(lo++,mid++,nums);
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(mid,hi--,nums);
            }
        }
    }
    void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}