package AfterContest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public static void main(String[] args) {
        //LeetCode 2402
        //https://leetcode.com/contest/weekly-contest-309/problems/meeting-rooms-iii/
    }
    static int solve(int n,int[][] meetings){
        int[] count = new int[n];

        Arrays.sort(meetings,(a, b)->a[0]-b[0]);

        PriorityQueue<Integer> unused = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            unused.add(i);
        }
        //{end time,room no}
        PriorityQueue<int[]> engaged= new PriorityQueue<>(
                (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]
        );

        for(int[] meet:meetings){
            int start =meet[0],end= meet[1];
            while(engaged.size()>0 && engaged.peek()[0]<=start){
                int room = engaged.poll()[1];
                unused.add(room);
            }
            if(unused.size()>0){// no need to delay meeting as rooms available
                int room = unused.poll();
                engaged.add(new int[]{end,room});
                count[room]++;
            }else{ // meeting will done after first meeting in queue finished
                int[] curr = engaged.poll();
                int room = curr[1],endTime = curr[0];
                int newEndTime = endTime+(end-start);
                engaged.add(new int[]{newEndTime,room});
                count[room]++;
            }

        }


        int maxi=0;
        for(int i=0;i<n;i++){
            if(count[maxi]<count[i]){
                maxi = i;
            }
        }
        return maxi;
    }
}
