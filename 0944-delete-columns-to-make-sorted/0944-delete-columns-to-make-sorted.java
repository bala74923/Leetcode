class Solution {
    public int minDeletionSize(String[] strs) {
        int res =0;
        for(int c=0;c<strs[0].length();c++){
            boolean delete = false;
            for(int ind=1;ind<strs.length;ind++){
                char curr = strs[ind].charAt(c), prev = strs[ind-1].charAt(c);
                if(prev>curr){
                   //System.out.printf("%c >%c \n",prev,curr); 
                    delete = true;
                    break;
                }
            }
            if(delete) res++;
        }
        return res;
    }
}