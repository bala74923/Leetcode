class Solution {
    public int maximum69Number (int num) {
        int n =(int)(Math.log(num)/Math.log(10));
        //System.out.println(n);
        int len =(int)Math.pow(10,n);
        while(len>0){
            int left = num/len,right = num%len;
            //System.out.printf("%d %d\n",left,right);
            int uni= left%10;
            if(uni==6){
                left/=10;
                left*=10;
                left+=9;
                return left*len+right;
            }
            len/=10;
        }
        return num;
    }
}