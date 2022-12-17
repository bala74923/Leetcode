class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens){
            if("+-/*".indexOf(s)!=-1){
                int t2 =  st.pop(),t1 = st.pop();
                char op = s.charAt(0);
                st.push(calc(t1,t2,op));
            }else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
    static int calc(int a,int b,char c){
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;
    }
}