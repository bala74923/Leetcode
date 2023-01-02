class Solution {
    public boolean detectCapitalUse(String word) {
        int all = 0;
        for(int i=1;i<word.length();i++){
            all = all +(word.charAt(i)<='Z'?1:0);
        }
        int first = (word.charAt(0)<='Z'?1:0);
        if(first==1 && all==word.length()-1) return true;
        if(first + all ==0) return true;
        if(first==1 && all ==0 ) return true;
        return false;
    }
}