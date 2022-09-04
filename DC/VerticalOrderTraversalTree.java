package DC;
import java.util.*;
/**
 * VerticalOrderTraversalTree
 */
public class VerticalOrderTraversalTree {
    Map<Integer,Map<Integer,List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        go(root,0,0);
        List<List<Integer>> list = new ArrayList<>();
        for(int col: map.keySet()){
            List<Integer> sub = new ArrayList<>();
            for(int row:map.get(col).keySet()){
                Collections.sort(map.get(col).get(row));
                sub.addAll(map.get(col).get(row));
            }
            list.add(sub);
        }
        return list;
    }
    void go(TreeNode root,int r,int c){
        if(root==null) return ;
        
        Map<Integer,List<Integer>> colMap = map.getOrDefault(c,new TreeMap<>());
        List<Integer> colArr = colMap.getOrDefault(r,new ArrayList<>());
        colArr.add(root.val);
        colMap.put(r,colArr);
        map.put(c,colMap);
        
        go(root.left,r+1,c-1);
        go(root.right,r+1,c+1);
    }
}