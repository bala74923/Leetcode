class StockSpanner {
    Stack<int[]> st;
    int index;
    public StockSpanner() {
        st = new Stack<>();
        index =0 ;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek()[0]<=price){
            st.pop();
        }
        int last= st.isEmpty()?-1:st.peek()[1];
        int result = index-last;
        st.push(new int[]{price,index});
        index++;
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */