class Trie{
    boolean end;
    Trie[] arr;
    Trie(){
        this.arr = new Trie[26];
        end = false;
    }
    void add(String s){
        Trie temp= this;
        for(char c: s.toCharArray()){
            int ind = c-'a';
           // System.out.println(s+"=>"+c);
            // if already present dont add
            if(temp.arr[ind]==null){
                temp.arr[ind] = new Trie();
                temp = temp.arr[ind];
            }else temp = temp.arr[ind];
        }
        temp.end = true;
    }
}
class Solution {
    Trie root;
    List<String> soln ;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        soln = new ArrayList<>();
        for(String word: wordDict){
            root.add(word);
        }
        rec(s,0,"");
        return soln;
    }
    void rec(String s,int start,String prev){
        if(start==s.length()) {
            soln.add(prev.substring(1));;
            return ;
        }
        Trie temp = root;
        int index= start;
        StringBuilder currSub = new StringBuilder(" ");
        while(index<s.length() && temp!=null){
            int charIndex = s.charAt(index)-'a';
            temp = temp.arr[charIndex];
            currSub.append(s.charAt(index));
            if(temp!=null && temp.end){ // possible end
                rec(s,index+1,prev+currSub.toString());
            }
            index++;
        }
    }
    
}