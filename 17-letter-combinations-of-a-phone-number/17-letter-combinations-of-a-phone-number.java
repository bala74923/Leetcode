class Solution {
    List<String> list;
    String[] letter = {"","","abc","def","ghi","jkl","mno","pqrs",
                     "tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        int N = digits.length();
        char[] s = new char[N];
        list = new ArrayList<>();
        rec(0,s,digits);
        return list;
    }
    void rec(int index,char[] s,String digits){
        if(index==s.length){
            if(index!=0)
                list.add(new String(s));
            return ;
        }
        for(char c: letter[digits.charAt(index)-'0'].toCharArray()){
            s[index] = c;
            rec(index+1,s,digits);
        }
    }
}