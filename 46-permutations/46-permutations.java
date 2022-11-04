class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list= new ArrayList<>();
        permute(0,nums);
        return list;
    }
    void permute(int lo,int[] nums){
        if(lo==nums.length){
            List<Integer> sub= new ArrayList<>();
            for(int val: nums) sub.add(val);
            list.add(sub);
        }
        for(int ind=lo;ind<nums.length;ind++){
            swap(nums,lo,ind);
            permute(lo+1,nums);
            swap(nums,lo,ind);
        }
    }
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}