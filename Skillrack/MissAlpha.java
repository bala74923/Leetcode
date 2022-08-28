package Skillrack;

public class MissAlpha{
    public static void main(String[] args) {
        System.out.println(check("moAn", "MON")?"YES":"NO");
    }
    static boolean check(String s1,String s2){
        int[] map = new int[26];
        for(char c:s2.toCharArray()){
            map[c-'A']++;
        }
        for(char c:s1.toCharArray()){
            if(c>96){ //lowercase
                //lower case -> pick  if in s2, not pick if not in s2
                if(map[c-'a']>1) map[c-'a']--;
            }else{ //upper case
                map[c-'A']--;
                if(map[c-'A']==-1){
                    return false;
                }
            }
        }
        return true;
    }
}
/*
 * s1 = moAn , s2 = MON
 * 1) upper case no remove
 * 2) lower case can be removed
 * 3) lower case can be change to upper case
 * 
 * MOAN 1) case fail so FALSE
 * 
 * s1 = lmon, s2 = MON
 *  TRUE
 */