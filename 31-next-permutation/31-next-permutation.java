class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int  ind=  -1;
        for(int i=N-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=  i;
                break;
            }
        }
        if(ind==-1){
            // decreasing order
            rev(nums,0,N-1);
            //return nums;
            return ;
        }
        int ng = -1,key = nums[ind];
        for(int i=ind;i<N;i++){
            if(nums[i]>key  && (ng==-1||nums[ng]-nums[key]>=nums[i]-nums[key]))
                ng = i;
        }
        swap(nums,ind,ng);
        rev(nums,ind+1,N-1);
        
    }
    static void rev(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;j--;
        }
    }
    static void swap(int[] nums ,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}