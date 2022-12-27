class pair{
    String first;
    double second;
    pair(String first,double second){this.first = first;this.second = second;}
}
class node{
    String first;
    double second;
    node(String first,double second){this.first = first;this.second = second;}
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<pair>> map = new HashMap<>();
        for(int i=0;i<values.length;i++){
            String from = equations.get(i).get(0), to = equations.get(i).get(1);
            double val = values[i];
            List<pair> sub = map.getOrDefault(from,new ArrayList<>());
            sub.add( new pair(to, val));
            map.put(from , sub);
            
            List<pair> sub2 = map.getOrDefault(to, new ArrayList<>());
            sub2.add(new pair(from ,1/val));
            map.put( to, sub2);
        }
        //System.out.println(map);
        
        int qn = queries.size();
        double[] res = new double[qn];
        int index = 0;
       for(List<String> qu: queries){
           String from = qu.get(0), des = qu.get(1);
           Set<String> vis = new HashSet<>();
           if(!des.equals(from)) vis.add(from);
           boolean found = false;
           Queue<node> q = new LinkedList<>();q.add( new node(from,1));
           while(!q.isEmpty()){
               node front = q.poll();
               if(front.first.equals(des) && vis.contains(front.first)){
                   res[index] = front.second;
                   //System.out.printf(" from=%s  des=%s curr=%s mul = %f\n",from,des,front.first,front.second);
                   found = true;
                   break;
               }
               double upto_dist =front.second;
               for(pair adj: map.getOrDefault(front.first, new ArrayList<>())){
                   String f = adj.first;
                   double ndist = adj.second * upto_dist;
                   if(vis.add(f)){ //  not visited already
                       q.add(new node(f, ndist));
                   }
               }
           }
           if(!found) res[index] = -1.0;
           index++;
       }
        return res;
    }
}