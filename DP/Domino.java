package DP;
import java.util.ArrayList;
import java.util.List;

public class Domino {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(pushDominoes("L.....RR.RL.....L.R."));
    }
    /*left 0->right to left normy
      left 1-> left to right obstacles

      right 0-> left to right normy
      right 1-> right to left obstacles
      */
    static int max = (int)1e9;
    static  String pushDominoes(String dominoes) {
        char[] arr =  dominoes.toCharArray();
        int N = arr.length;
        int[][] left = new int[N][2], right = new int[N][2];
        left[0][1]=right[0][0]=max;
        left[N-1][0]=right[N-1][1]=max;
        for(int ind=0,index=N-1;ind<N;ind++,index--){
            if(arr[ind]=='L') left[ind][1] = ind;
            else if(ind>0) left[ind][1] = left[ind-1][1];

            if(arr[ind]=='R') right[ind][0] = ind;
            else if(ind>0) right[ind][0] = right[ind-1][0];

            if(arr[index]=='L') left[index][0] = index;
            else if(index!=N-1) left[index][0] = left[index+1][0];

            if(arr[index]=='R') right[index][1] = index;
            else if(index!=N-1) right[index][1] = right[index+1][1];
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='.'){
                int leftDist = left[i][0],rightDist = right[i][0];
                if(leftDist!=max||rightDist!=max){
                    boolean isLnear = Math.abs(leftDist-i)<Math.abs(i-rightDist), isRnear  = !isLnear;
                    boolean LCross = leftDist<=right[i][1]||right[i][1]==max,RCross = rightDist>=left[i][1]||left[i][1]==max;
                    if(Math.abs(leftDist-i)==Math.abs(i-rightDist) && LCross &&RCross) continue;
                    if(isLnear){
                        if(LCross) arr[i]='L';
                        else if(rightDist!=max && RCross) arr[i]='R';
                    }else{
                        if(RCross) arr[i]='R';
                        else if(leftDist!=max && LCross) arr[i]='L';
                    }
                }
            }
        }
        return new String(arr);
    }
}
