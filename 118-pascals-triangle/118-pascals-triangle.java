class Solution {
    public List<List<Integer>> generate(int n) {
        List< List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for(int i=1;i<n;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<=i;j++){
                int p1= j>0?list.get(i-1).get(j-1):0;
                int p2 = i==j?0:list.get(i-1).get(j);
                curr.add(p1+p2);
            }
            list.add(curr);
        }
        return list;
    }
   
}