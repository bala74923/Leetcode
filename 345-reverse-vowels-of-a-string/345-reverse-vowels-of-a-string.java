class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int lo=0, hi=s.length()-1;
        while(lo<hi){
            while(lo<hi && !isVowel(s.charAt(lo))) lo++;
            while(lo<hi && !isVowel(s.charAt(hi))) hi--;
            swap(arr,lo,hi);
            lo++;
            hi--;
        }
        return new String(arr);
    }
    boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
    void swap(char[] arr,int i,int j){
        char temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}