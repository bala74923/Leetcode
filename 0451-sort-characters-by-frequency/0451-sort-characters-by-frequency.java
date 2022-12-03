class Solution {
    public String frequencySort(String s) {
       int[] arr = new int[128];
       for(char c:s.toCharArray()) arr[c]++;
       PriorityQueue<Integer> pq = new PriorityQueue<>(
           (a,b)->arr[a]==arr[b]?a-b:arr[b]-arr[a]);
       for(int i=0;i<128;i++){
           if(arr[i]>0) pq.add(i);
       }
        char[] res  = new char[s.length()];
        int index = 0;
        while(!pq.isEmpty()){
            char c = (char)((int)pq.poll());
            while(arr[c]-->0){
                res[index++] = c;
            }
        }
        return new String(res);
    }
}