class Solution {
    public int ladderLength(String b, String e, List<String> list) {
        Set<String> set= new HashSet<>(list);
        Queue<String> q = new LinkedList<>();
        int level=1;
        q.add(b);
        while(!q.isEmpty()){
            int size=  q.size();
            while(size-->0){
                String front = q.poll();
                if(front.equals(e)) return level;
                int len = front.length();
                char[] arr = front.toCharArray();
                for(int ind=0;ind<len;ind++){
                    char temp = arr[ind];
                    for(char c='a';c<='z';c++){
                        arr[ind] = c;
                        String curr= new String(arr);
                        if(set.contains(curr)){
                            q.add(curr);
                            set.remove(curr);
                        }
                    }
                    arr[ind] = temp;
                }
            }
            ++level;
        }
        return 0;
    }
}