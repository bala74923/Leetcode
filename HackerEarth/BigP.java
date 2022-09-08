package HackerEarth;
import java.util.*;
public class BigP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int top = sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        while(true){
            int from = sc.nextInt(),to = sc.nextInt();
            if(from==0 && to==0)
                break;
            List<Integer> paths = map.getOrDefault(from,new ArrayList<>());
            paths.add(to);
            map.put(from,paths);
        }
        int[] memo = new int[top+1];
        for(int i=0;i<=top;i++)
            memo[i] = -1;
        System.out.println(count(map,1,top,memo));
    }
    static int count(Map<Integer,List<Integer>> map,int val,int top,int[] memo){
        if(val==top)
            return 1;
        if(memo[val]!=-1)
            return memo[val];
        int c = 0;
        for(int to:map.getOrDefault(val,new ArrayList<>()))
            c+=count(map,to,top,memo);
        return memo[val] = c;
    }
}
