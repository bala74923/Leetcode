class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && (st.peek()^32) == c){
                st.pop();
            }else st.push(c);
        }
        char[] arr  = new char[st.size()];
        int last= st.size()-1;
        while(!st.isEmpty()){
            arr[last--] = st.pop();
        }
        return new String(arr);
    }
}