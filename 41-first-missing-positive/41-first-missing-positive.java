class Solution {
    public int firstMissingPositive(int[] nums) {
        int ind = 0,base = 1;
        while(ind<nums.length){
            int correct = nums[ind]-base;
            if(isValid(correct, nums.length) && nums[ind]!=nums[correct]){
                swap(nums,ind,correct);
            }else ind++;
        }
      //  System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(i+1 != nums[i]) return i+1;
        }
        return nums.length+1;
    }
    static boolean isValid(int ind,int n){
        return ind>=0 && ind<n;
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}