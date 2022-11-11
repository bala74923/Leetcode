```
class Solution {
int res =0;
public int maxPathSum(TreeNode root) {
res = -(int)1e9;
go(root);
return res;
}
int go(TreeNode root){
if(root==null) return 0;
// we can skip left part if it is negative
int left = Math.max(go(root.left),0);
// we can skip right part if it is negative
int right= Math.max(go(root.right),0);
// we cannot skip the current part because curver os
// passing throught the current part
res = Math.max(res,left+right+root.val);
return Math.max(left,right)+root.val;
}
}
```