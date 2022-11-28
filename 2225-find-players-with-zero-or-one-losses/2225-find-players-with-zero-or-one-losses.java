class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> lcount = new 
            TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());res.add(new ArrayList<>());
        for(int[] m:matches){
            int w = m[0],l = m[1];
            lcount.put(l,lcount.getOrDefault(l,0)+1);
            lcount.put(w,lcount.getOrDefault(w,0));
        }
        for(int val:lcount.keySet()){
            if(lcount.get(val)==1)
                res.get(1).add(val);
            if(lcount.get(val)==0)
                res.get(0).add(val);
        }
        return res;
    }
}