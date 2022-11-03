class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list= new ArrayList<>();
        char[] res = new char[2*n];
        rec(n,0,0,res);//open-> no of bending paranthest to open
        // close-> no of bending paranthses to close
        return list;
    }
    void rec(int open,int close,int index,char[] str){
        if(index==str.length){
            list.add(new String(str));
            return ;
        }
        if(open>0){
            str[index] = '(';
            rec(open-1,close+1,index+1,str);
            str[index] = '\0'; // unset
        }if(close>0){
            str[index]=')';
            rec(open,close-1,index+1,str);
            str[index] = '\0'; // unset
        }
    }
}