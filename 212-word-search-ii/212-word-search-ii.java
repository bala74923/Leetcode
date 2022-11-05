class Trie{
    Trie[] arr;
    boolean end ;
    String str;
    Trie(){
        this.arr = new Trie[26];
        str = null;
        end = false;
    }
    void addWord(String s){
        Trie temp = this;
        for(char c: s.toCharArray()){
            // check is already exist or not
            int ind = c-'a';
            if(temp.arr[ind]==null){
                temp.arr[ind] = new Trie();
            }
            temp = temp.arr[ind];
        }
        temp.end = true;
        temp.str = s;
    }
}
class Solution {
    Set<String> list;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String s: words) root.addWord(s);
        list = new HashSet<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        this.board=  board;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,vis,root);
            }
        }
        return  new ArrayList<>(list);
    }
    void dfs(int i,int j,boolean[][] visited, Trie temp){
        if(i<0 || j<0|| i>=board.length|| j>=board[0].length ||  visited[i][j]) return ;
        int ind = board[i][j]-'a';
        if(temp.arr[ind]==null) return ;
        visited[i][j] = true;
        // check is there any element having this
        temp= temp.arr[ind];
        //System.out.println(board[i][j]);
        if(temp.end==true) list.add(temp.str);
            
        int[][] dirs ={{-1,0},{0,1},{1,0},{0,-1}};
        for(int[] dir: dirs){
            int x= dir[0]+i,y =dir[1]+j;
            dfs(x,y,visited,temp);
        }
        
        visited[i][j] = false;
    }
}