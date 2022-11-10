class Pair{
    String str;
    int val;
    Pair(String str,int val){this.str=  str;this.val = val;}
    
}
class Solution {
    int max = (int)1e9;
    public int ladderLength(String beginWord, String endWord, List<String> list) {
        int N = list.size();
        boolean[] visited =new boolean[N];
        
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        while(!q.isEmpty()){
            Pair front = q.poll();
            if(front.str.equals(endWord)) return front.val;
            for(int i=0;i<N;i++){
                if(!visited[i] && check(front.str,list.get(i))){
                    // comparable or not
                        q.add(new Pair(list.get(i),front.val+1));
                        visited[i] = true;
                }
            }
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