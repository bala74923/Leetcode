class Solution {
    List<List<String>> soln;
    List<String> rec_stack;
    public List<List<String>> partition(String s) {
        soln = new ArrayList<>();
        rec_stack = new ArrayList<>();
        f(0,s);
        return soln;
    }
    void f(int ind,String s){
        if(ind== s.length()){
            soln.add(new ArrayList<>(rec_stack));
            return ;
        }
        StringBuilder sb = new StringBuilder("");
        for(int end=ind;end<s.length();end++){
            sb.append(s.charAt(end));
            if(ispal( s, ind, end)){
                rec_stack.add(sb.toString());
                f(end+1,  s);
                rec_stack.remove(rec_stack.size()-1);
            }    
        }
    }
    boolean ispal(String s,int lo,int hi){
        while(lo<hi){
            if(s.charAt(lo++) != s.charAt(hi--))
                return false;
        }
        return true;
    }
    
}