package DC;

import java.util.Arrays;

public class Bag_of_Tokens {
    public int bagOfTokensScore(int[] arr, int power) {
        Arrays.sort(arr);
        int score = 0,max = 0,i=0,j=arr.length-1;
        while(i<=j){
            if(arr[i]<=power){
                int val = arr[i++];
                power-=val;
                score++;
            }else if(score>0){
                score--;
                int val = arr[j--];
                power+=val;
            }else break;
            max = Math.max(max,score);
        }
        return max;
    }


}
