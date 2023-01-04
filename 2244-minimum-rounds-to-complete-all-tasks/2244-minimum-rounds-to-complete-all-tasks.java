class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: tasks)
            map.put(n, map.getOrDefault(n,0)+1);
        int res = 0;
        for(int n: map.keySet()){
            int cnt = map.get(n);
            if(cnt == 1) return -1;
            int two = (cnt/3)+(cnt%3!=0?1:0); // add that extra one to any other two
            res+=two;
        }
        return res;
    }
}