class Solution {
    int int_max=  (int)1e9;
    int min;
    Set<String> soln;
    public List<String> removeInvalidParentheses(String s) {
        min = int_max;
        soln = new HashSet<>();
        rec(0,0,s.toCharArray());
        return new ArrayList<>(soln);
    }
    void rec(int index,int del,char[] s){
        // making more changes than already available one
        if(del>min) return ;
        if(index==s.length){
            if(check(s)){
                // valid
                if(del<min){
                    min = del;
                    soln = new HashSet<>();
                }
                //if(del==min)
                    soln.add(print(s));
            }     
            return ;
        }
        // if character skip
        if(Character.isAlphabetic(s[index])){
            rec(index+1,del,s);
            return ;
        }
        // if parantheses
        
        // this function gives us less del val so do this first
        // dont delte this one
        rec(index+1,del,s);
        //delte this one
        char temp = s[index];
        s[index] = '$';
        rec(index+1,del+1,s);
        s[index] = temp;
    }
    static String print(char[] s){
        StringBuilder sb = new StringBuilder();
        for(char c: s){
            //$-> deleted
            if(c!='$') sb.append(c);
        }
        return sb.toString();
    }
    static boolean check(char[] arr){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='(') st.push(arr[i]);
            if(arr[i]==')'){
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}