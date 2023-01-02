class pair{
    String str;
    double num;
    pair(String str,double num){
        this.str = str;
        this.num = num;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<pair>> map = new HashMap<>();
        for(int i=0;i<values.length;i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            
            List<pair> l1 = map.getOrDefault(a,new ArrayList<>());
            l1.add(new pair(b,values[i]));
            map.put(a,l1);
            
            List<pair> l2 = map.getOrDefault(b,new ArrayList<>());
            l2.add(new pair(a,1/values[i]));
            map.put(b,l2);
        }
        // graph created
        //query has to be processed here
        int size = queries.size();
        double[] res = new double[size];
        for(int i=0;i<size;i++){
            res[i] = calc(map, queries.get(i).get(0),queries.get(i).get(1));
        }
        return res;
    }
    double calc(Map<String,List<pair>> map,String a,String b){
        if(!map.containsKey(a)|| !map.containsKey(b))
            return -1.0;
        if(a.equals(b)) 
            return 1.0;
        // perform bfs now
        Set<String> visited = new HashSet<>();
        Queue<pair> q = new LinkedList<>();
        q.add( new pair(a,1.0));visited.add(a);
        while(!q.isEmpty()){
            pair front = q.poll();
            String curr_var = front.str; double upto = front.num;
            if(curr_var.equals(b))
                return upto;
            for(pair adj: map.getOrDefault(curr_var, new ArrayList<>())){
                String adj_var = adj.str; double new_upto = upto*adj.num;
                if(visited.add(adj_var)){
                    q.add( new pair(adj_var, new_upto));
                }
            }
        }
        return -1.0;
    }
}