class Solution {
    public int longestPalindrome(String[] words) {
        int[][] map = new int[26][26];
        int count = 0;
        for(String s:words){
            int c1 = s.charAt(0)-'a', c2= s.charAt(1)-'a';
            if(map[c2][c1]>0){
                count+=4;
                map[c2][c1]--;
                // no need to decrement map[c1][c2] it is still not added
            }
            else map[c1][c2]++;
        }
        int extra = 0;
        for(int i=0;i<26;i++){
            if(map[i][i]>0) extra = 2;
        }
        return count+extra;
    }
}