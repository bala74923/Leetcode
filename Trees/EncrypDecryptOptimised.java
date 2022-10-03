package Trees;

public class EncrypDecryptOptimised {
    public static void main(String[] args) {

    }
    static StringBuilder sb ;
    static String encrypt(TreeNode root){
        sb = new StringBuilder();
        preOrder(root);
        String res = sb.toString();
        if(res.length()>0) res = res.substring(1);
        return res;
    }
    static int index = 0;
    static TreeNode decrypt(String s){
        String[] arr = s.split(",");
        index = 0;
        return get(arr);
    }
    static TreeNode get(String[] arr){
        if(index>=arr.length|| arr[index].length()==0 ||
        arr[index].equals("null"))
            return null;
        TreeNode curr = new TreeNode(Integer.parseInt(arr[index++]));
        curr.left = get(arr);
        curr.right = get(arr);
        return curr;
    }
    static void preOrder(TreeNode node){
        if(node==null){
            sb.append(",null");
            return;
        }
        sb.append(","+node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
