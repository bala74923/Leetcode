package DC;
import java.util.*;
public class AvgOfBinaryLevels {
    public static void main(String[] args){

    }
    List<long[]> list ;
    public List<Double> averageOfLevels(TreeNode root) { //3ms
        list = new ArrayList<>();
        dfs(root,0);
        List<Double> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++)
            ans.add(list.get(i)[0]/(double)list.get(i)[1]);
        return ans;
    }
     void dfs(TreeNode root,int depth){
        if(root==null)
            return ;
        if(depth>=list.size()) list.add(new long[]{root.val,1l});// not exist
        else{
            long[] pre = list.get(depth);
            list.set(depth,new long[]{pre[0]+root.val,++pre[1]});
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
