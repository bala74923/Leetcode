class Pair{
    String str;
    int val;
    Pair(String str,int val){this.str=  str;this.val = val;}
    
}
class Solution {
    int max = (int)1e9;
    public int ladderLength(String beginWord, String endWord, List<String> list) {
        int N = list.size();
        int[] dist = new int[N];
        for(int i=0;i<N;i++){
            dist[i] = max;
        }
        
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord,0));
        
        while(!q.isEmpty()){
            Pair front = q.poll();
            for(int i=0;i<N;i++){
                if(check(front.str,list.get(i))){
                    // comparable or not
                    
                    if(dist[i]>front.val+1){
                        dist[i] = front.val+1;
                        q.add(new Pair(list.get(i),dist[i]));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        
        for(int i=0;i<N;i++){
            if(list.get(i).equals(endWord))
                return dist[i]==max?0: dist[i]+1;
        }
        return 0;
    }
    static boolean check(String s1,String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) 
                count++;
        }
        return count<=1;
    }
}