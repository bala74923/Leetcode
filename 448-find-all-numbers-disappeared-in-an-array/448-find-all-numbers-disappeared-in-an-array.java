class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        sort(nums);
        //System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) list.add(i+1);
        }
        return list;
    }
    void sort(int[] nums){
        int ind =0;
        while(ind<nums.length){
            int correct = nums[ind]-1;
            if(nums[ind]!=nums[correct]){
                swap(nums,ind,correct);
            }else ind++;
        }
    }
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}