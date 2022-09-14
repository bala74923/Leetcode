package DC;

public class Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    public int pseudoPalindromicPaths (TreeNode root) {
        return go(root,new int[10]);
    }
    int go(TreeNode root,int[] count){
        if(root==null) return 0;
        count[root.val]++;
        int left  =  go(root.left,count);
        int right = go(root.right,count);
        int leaf= 0;
        if(root.left==null && root.right==null && check(count))
            leaf++;
        count[root.val]--;
        return left + right +leaf;
    }
    boolean check(int[] arr){
        int ones =0 ;
        for(int i=0;i<10;i++){
            ones+= (arr[i]&1);
        }
        //System.out.println(Arrays.toString(arr)+"=>"+ones);
        return ones<=1;
    }
}
