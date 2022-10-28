package DC;

import javax.sound.sampled.Line;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
/*
nums = [1,3,5,2,7,5], minK = 1, maxK = 5

 */
public class fixedBoundArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
    }
    static long solve(int[] arr,int mink,int maxk){
        int preIndex = 0, currIndex = 0 , mini = Integer.MAX_VALUE,
                maxi = Integer.MIN_VALUE;
        long res = 0;
        Deque<Integer> minq = new LinkedList<>(), maxq = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(mink<= arr[i] && arr[i]<=maxk){
                while(!minq.isEmpty() && arr[minq.peekLast()]>=arr[i])
                    minq.pollLast();
                minq.add(i);
                while(!maxq.isEmpty() && arr[maxq.peekLast()]<=arr[i])
                    maxq.pollLast();
                maxq.add(i);
            }else{
                // dont consider
                if(!minq.isEmpty() && !maxq.isEmpty() && mink==arr[minq.peekFirst()] && maxk ==arr[maxq.peekFirst()]) {
                    res+= 1+ i-Math.max(minq.peekLast(),maxq.peekLast());
                }
                minq.clear();
                maxq.clear();
            }

        }
        return res;
    }
}
