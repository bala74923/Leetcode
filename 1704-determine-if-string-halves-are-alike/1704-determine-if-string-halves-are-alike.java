class Solution {
    public boolean halvesAreAlike(String s) {
        int N=s.length();
        return countVowel(s,0,N>>1)==countVowel(s,N>>1,N);
    }
    static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)>-1;
    }
    static int countVowel(String s,int start,int e){
        int count= 0;
        for(;start<e;start++){
            if(isVowel(s.charAt(start)))
                count++;
        }
        return count;
    }
}