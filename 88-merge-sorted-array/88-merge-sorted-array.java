class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //  fill array 
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        int gap = (m+n)/2 + (m+n)%2;
        while(true){
            int i = 0, j = gap;
            while(j<m+n){
                if(nums1[i]>=nums1[j])
                    swap(nums1,i,j);
                j++;
                i++;
            }
            if(gap==1) break;
            gap= (gap>>1) + (gap&1);
        }
    }
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}