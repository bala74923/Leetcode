package DC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NoOfConsecutiveDifferences
 */
public class NoOfConsecutiveDifferences {
    public static void main(String[] args) {
        int[] array = numsSameConsecDiff(3, 7);
        System.out.println(Arrays.toString(array));
    }
    static List<Integer> list;
    public static int[] numsSameConsecDiff(int n, int k) { //2ms
        list = new ArrayList<>();

        
        for(int i=1;i<=9;i++){
            addNumber(i, n-1, k);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<ans.length;i++)
            ans[i] = list.get(i);
        return ans;
    }
    static void addNumber(int curr,int len,int diff){
        if(len==0){
            list.add(curr);
            return;
        }
        // +diff or -diff is possible
        int unitDigit = curr%10;
        if(unitDigit>=diff)
            addNumber(curr*10+(unitDigit-diff) , len-1, diff);
        if(unitDigit+diff<=9 && diff!=0)
            addNumber(curr*10+(unitDigit+diff), len-1, diff);

    }
}