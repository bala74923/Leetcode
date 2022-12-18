class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int N = arr.length;
        int[] nge = new int[N];
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
                st.pop();
            nge[i] = st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        return nge;
    }
}