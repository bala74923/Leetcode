package Trees;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static void main(String[] args) {

    }
    static int neg = -(int)1e9;
    static String serialize(TreeNode root){
        int h = findHeight(root);
        int[] arr = new int[(1<<h)-1];
        Arrays.fill(arr,neg);
        formTree(arr,0,root);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            res.append(",");
            res.append(arr[i]);
        }
        String ans = res.toString();
        if(ans.length()>0) ans = ans.substring(1);
        return ans;
    }
    static TreeNode deserialize(String s){
        String[] a = s.split(",");
        return make(a,0);
    }
    static TreeNode make(String[] arr,int index){
        if(index>= arr.length||
                arr[index].length()==0||
                Integer.parseInt(arr[index])==neg)
            return null;
        TreeNode curr = new TreeNode(Integer.parseInt(arr[index]));
        curr.left = make(arr,2*index+1);
        curr.right = make(arr,2*index+2);
        return curr;
    }
    static void formTree(int[] tree,int index,TreeNode root){
        if(root==null) return ;
        tree[index] = root.val;
        formTree(tree,2*index+1,root.left);
        formTree(tree,2*index+2,root.right);
    }
    static String levelForm(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(new Pair(root,0));
        int trackIndex = 0;
        while(!q.isEmpty()){
            Pair frontPair = q.poll();
            if(frontPair.node==null) break;
//            while(frontPair.ind!=trackIndex){
//                res.append(",");res.append("-1");
//                trackIndex++;
//            }
            int times = frontPair.ind-trackIndex;
            res.append((","+neg).repeat(times));
            res.append(",");res.append(frontPair.node.val);
            if(frontPair.node.left!=null)
                q.add(new Pair(frontPair.node.left,trackIndex*2+1));
            if(frontPair.node.right!=null)
                q.add(new Pair(frontPair.node.right,trackIndex*2+2));
            trackIndex++;
        }
        String ans = res.toString();
        if(ans.length()>0) ans = ans.substring(1);
        return ans;
    }
   static  int findHeight(TreeNode root){
        if(root==null) return 0;
        int left = findHeight(root.left);
        int right= findHeight(root.right);
        return Math.max(left,right)+1;
    }
}
class Pair{
    TreeNode node;
    int ind;
    Pair(TreeNode node,int ind){
        this.node = node;
        this.ind = ind;
    }
}