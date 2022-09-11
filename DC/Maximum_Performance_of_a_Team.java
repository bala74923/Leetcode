package DC;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Performance_of_a_Team {
    public static void main(String[] args) {

    }
    static int mod = (int)1e9+7;
    static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int res = 0;
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            arr[i] = new int[]{ speed[i] , efficiency[i] };
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxSum=0;
        for(int i=0;i<arr.length;i++){
            maxSum+= arr[i][0]; //adding speed
            pq.add(arr[i][0]);
            while(pq.size()>k){
                maxSum-=pq.poll();// removing low speed
            }
            res = Math.max(res,maxSum*arr[i][1]);
        }

        return res%mod;
    }

}
