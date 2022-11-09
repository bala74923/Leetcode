class Solution {
    public int[] findErrorNums(int[] nums) {
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]){
                return new int[]{nums[i],i+1};
            }
        }
        return null;
    }
    void sort(int[] nums){
        int ind = 0;
        while(ind<nums.length){
            int pos = nums[ind]-1;
            if(nums[pos]!=nums[ind]) swap(nums,ind,pos);
            else ind++;
        }
    }
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}