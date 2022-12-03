class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] arr = new int[26],arr2 = new int[26];
        int n1=0,n2=0;
        for(char c: word1.toCharArray()) {
            arr[c-'a']++;
            n1 = n1|(1<<(c-'a'));
        }
        for(char c: word2.toCharArray()) {
            arr2[c-'a']++;
            n2 = n2|(1<<(c-'a'));
        }
        
        arr = sort(arr);
        arr2 = sort(arr2);
        
        return (n1^n2)==0 &&Arrays.equals(arr,arr2);
        
    }
    static int[] sort(int[] arr){
        int max =0 ;
        for(int n: arr) max = Math.max(max,n);
        
        int[] count= new int[max+1];
        for(int n: arr) count[n]++;
        
        for(int i=1;i<=max;i++)
            count[i]+=count[i-1];
        
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[--count[arr[i]]] = arr[i];
        }
        return res;
    }
}