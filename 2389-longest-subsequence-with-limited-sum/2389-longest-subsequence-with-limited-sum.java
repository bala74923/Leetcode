class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int M = queries.length;
        int[] res = new int[M];
        TreeMap<Integer,Integer> map  = new TreeMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            map.put(sum, i);
        }
        for(int i=0;i<M;i++){
            int q = queries[i];
            try{
                int key = map.floorKey(q);
                res[i] = map.get(key)+1;
            }catch(Exception e){}
        }
        return res;
    }
}