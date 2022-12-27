class Pair{
    String first;
    double second;
    Pair(String first, double second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create graph from nodes and values
        Map<String, List<Pair>> map = graph(equations, values);
        double[] res = new double[queries.size()];
        int index = 0;
        for(List<String> q: queries){
            String from = q.get(0), to = q.get(1);
            if(map.get(from)==null || map.get(to)==null )
                res[index++] = -1.0;
            else 
                res[index++] = Math.max( dfs( from, to, new HashSet<>(), map) ,-1);
        }
        return res;
    }
    double int_min = -(int)1e9;
    double dfs(String curr,String des,Set<String> visited,
               Map<String,List<Pair>> map){
        //System.out.println(curr+" = curr , des = "+des);
        if(curr.equals(des)) return 1.0;
        if(visited.contains(curr)) return int_min; // this will neglect the wron answer
        visited.add(curr);
        double res = int_min;
        
        for(Pair adj: map.get(curr)){
            String adj_node = adj.first;
            double dist = adj.second;
            double calc = dist* dfs( adj_node, des, visited,map);
            res = Math.max(res, calc);
        }
        return res;
    }
    Map<String,List<Pair>> graph(List<List<String>> edges,double[] v){
        int N = v.length;
        Map<String,List<Pair>>  map = new HashMap<>();
        for(int i=0;i<N;i++){
            double dist = v[i];
            String from = edges.get(i).get(0), to = edges.get(i).get(1);
            
            List<Pair> list1 = map.getOrDefault(from, new ArrayList<>());
            list1.add( new Pair(to, dist));
            map.put( from, list1);
            
            List<Pair> list2 = map.getOrDefault(to, new ArrayList<>());
            list2.add( new Pair(from, 1/dist));
            map.put( to , list2);
        }
        return map;
    }
}