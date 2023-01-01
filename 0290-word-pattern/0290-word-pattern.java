class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] subs = s.split("\\s+");
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> rev = new HashMap<>();
        if(pattern.length()!=subs.length) return false;
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word= subs[i];
            if(map.containsKey(c) && rev.containsKey(word)){
                // check both match thats all
                if(map.get(c).equals(word) && rev.get(word)==c)
                   continue;
                else return false;
            }else if(map.containsKey(c)) return false;
            else if(rev.containsKey(word)) return false;
            else{ 
                map.put(c,word);
                rev.put(word,c);
            }
        }
        return true;
    }
}