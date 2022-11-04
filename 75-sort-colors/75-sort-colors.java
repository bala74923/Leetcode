class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int n: nums) count[n]++;
        // cumulative frequency
        for(int i=1;i<=2;i++) count[i]+=count[i-1];
        int[] narr = nums.clone();
        for(int i=nums.length-1;i>=0;i--){
            nums[--count[narr[i]]] = narr[i];
        }
    }
}