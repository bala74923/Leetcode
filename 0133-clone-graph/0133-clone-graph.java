/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer,Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return clone(node);
    }
    Node clone(Node node){
        if(node==null)
            return null;
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node nn = new Node(node.val);
        map.put(node.val , nn);
        for(Node org_adj: node.neighbors){
            nn.neighbors.add( clone(org_adj) );
        }
        return nn;
    }
}