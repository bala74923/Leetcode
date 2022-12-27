class Solution {
    double int_max = (int)1e3;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> cands = new HashSet<>();
        Map<List<String>,Double> map = new HashMap<>();
        // diagonals are 1, default is int_max
        int N = values.length;
        for(int i=0;i<N;i++){
            String from = equations.get(i).get(0) , to= equations.get(i).get(1);
            double dist = values[i];
            
            map.put(hash(from,to), dist);
            map.put(hash(to,from),1/dist);
            
            cands.add(from);cands.add(to);
        }
        
        for(String i: cands){
            map.put( hash(i,i), 1.0); // for self loop;
        }
        
        for(String k: cands){
            for(String i: cands){
                for(String j: cands){
                    double dist = map.getOrDefault(hash(i,j),int_max);
                    double ik = map.getOrDefault(hash(i,k),int_max);
                    double kj =  map.getOrDefault(hash(k,j),int_max);
                    if(ik!=int_max && kj!=int_max && dist> ik*kj){
                        map.put(hash(i,j), ik*kj);
                    }
                }
            }
        }
        int size = queries.size();
        double[] res = new double[size];
        int index = 0;
        for(List<String> q: queries){
            res[index++] = map.getOrDefault(q,-1.0);
        }
        return res;
    }
    List<String> hash(String a,String b){
        List<String> list = new ArrayList<>();
        list.add(a); list.add(b);
        return list;
    }
}