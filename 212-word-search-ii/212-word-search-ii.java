class Trie{
    Trie[] arr;
    String str;
    Trie(){
        this.arr = new Trie[26];
        str = null;
    }
    void addWord(String s){
        Trie temp = this;
        for(char c: s.toCharArray()){
            int ind = c-'a';
            // if not present add
            if(temp.arr[ind]==null){
                temp.arr[ind] = new Trie();
                temp = temp.arr[ind];
            }else temp = temp.arr[ind];
            // else skip
        }
        // at the last character 
        temp.str = s;
    }
}

class Solution {
     int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    Set<String> soln;
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        Trie root = new Trie();
        soln = new HashSet<>();
        for(String word: words) root.addWord(word);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rec(i,j,board,root);
            }
        }
        return new ArrayList<>(soln);
    }
    void rec(int i,int j,char[][] board, Trie temp){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='$'|| 
          temp==null){
            // is not valid or already visited
            return ;
        }
       
        char tmpchar = board[i][j];
        board[i][j] = '$'; // marking it as visited
        // if valid add the current value
        // if not present then add else leave it
        int ind = tmpchar-'a';
        
        Trie child = temp.arr[ind]; 
         if(child!=null && child.str!=null){
            // we found some character
            //System.out.println(i+","+j);
            soln.add(child.str);
        }
        for(int[] dir: dirs){
            int x = i+dir[0], y = j+dir[1];
            rec(x,y,board,child);
        }
        board[i][j] = tmpchar;
    }
    
}
// make all possible strings using backtracking