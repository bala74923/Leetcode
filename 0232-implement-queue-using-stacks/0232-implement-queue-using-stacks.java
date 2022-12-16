class MyQueue {
    Stack<Integer> st ;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        Stack<Integer> anotherStack = new Stack<>();
        int last = -1;
        while(!st.isEmpty()){
            last = st.pop();
            if(!st.isEmpty())
                anotherStack.push(last);
        }
        while(!anotherStack.isEmpty())
            st.push(anotherStack.pop());
        return last;
    }
    
    public int peek() {
         Stack<Integer> anotherStack = new Stack<>();
        int last = -1;
        while(!st.isEmpty()){
            last = st.pop();
           
                anotherStack.push(last);
        }
        while(!anotherStack.isEmpty())
            st.push(anotherStack.pop());
        return last;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */