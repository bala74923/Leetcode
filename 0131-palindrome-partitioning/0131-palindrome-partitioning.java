class Solution{
    public List<List<String>> partition(String s) {
        List<List<String>> soln  = new ArrayList<>();
        
        List<String> curr = new ArrayList<>();
        curr.add(s.charAt(0)+"");
        Queue<List<String>> q = new LinkedList<>();
        q.add(curr);
        
        int ind= 1;
        while(ind<s.length()){
            int size = q.size();
           // System.out.println(ind-1);
            char c = s.charAt(ind);
            //System.out.println(q+" upcoming = "+c);
            
            for(int i=0;i< size;i++){
                List<String> front = q.poll();
                String last = front.get(front.size()-1);
                 // another option is create a new list
                List<String> new_list = new ArrayList<>(front);
                new_list.add( c+"" );
                q.add(new_list);
                    front.remove(front.size()-1);
                    front.add(last+c);
                    q.add(front);
            } 
            ind++;
        }
        while(!q.isEmpty()){
            List<String> st =q.poll();
            if(ispal(st)) soln.add(st);
        
        }
        return soln;
    }
    boolean ispal(List<String> l){
        for(String s: l){
            int lo= 0,hi = s.length()-1;
            while(lo<hi){
                if(s.charAt(lo++) != s.charAt(hi--))
                    return false;
            }
        }
        return true;
    }
    
}