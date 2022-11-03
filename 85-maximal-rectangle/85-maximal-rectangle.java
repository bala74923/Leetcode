class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length,c = matrix[0].length;
        int[] heights = new int[c];
        int maxi =0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]=='1')heights[j]++;
                else heights[j]=0;
            }
            maxi = Math.max(maxi,largestRectangleArea(heights));
        }
        return maxi;
    }
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] left = new int[N];
        int[] right = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i] )
                st.pop();
            left[i] = st.isEmpty()?-1: st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i] )
                st.pop();
            right[i] = st.isEmpty()?N: st.peek();
            //System.out.println("st = "+st);
            st.push(i);
        }
        //System.out.printf("%s %s",Arrays.toString(left),Arrays.toString(right));
        int maxi =0;
        for(int i=0;i<N;i++){
            maxi  = Math.max(maxi, (right[i]-left[i]-1)*heights[i]);
        }
        return maxi;
    }
}