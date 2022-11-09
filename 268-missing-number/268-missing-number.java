class Solution {
    public int missingNumber(int[] nums) {
        cycleSort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]) return i;
        }
        return nums.length;
    }
    void cycleSort(int[] nums){
        int i =0;
        while(i<nums.length){
            int pos = nums[i];
            if(nums[i]!=nums.length && i!=nums[i]){
                // swap
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                //
            }else i++;
        }
    }
}