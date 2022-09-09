package DC;

import java.util.Arrays;
import java.util.Stack;

public class WeakCharacters {
    public static void main(String[] args) {

    }
    public int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        Arrays.sort(properties,(a, b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        int max = properties[0][1];
        for(int i=1;i<properties.length;i++){
            if(properties[i][0]<properties[0][0]&&properties[i][1]<max){
                count++;
            }
            max = Math.max(max,properties[i][1]);
        }
        return count;
    }
}
/*
both elements of array has to be smaller then only can be counted as weak character

first we sort one side of array,
and we track another side of array for max element
if any character has another side as less than previous than it is weak character

sorting matters [attack,defense]
================

as usual we sort the array in descending order one side
if both one side elements are equal

{[7,1],[7,2],[7,3]}
here if we sort descending order we get
[[7,3],[7,2],[7,1]]
and we keep track max , max will be updated as 3
if we check 2<max(3) its true it counts
but actually both have same one side element,it should not be counted

so we sort another side in ascending order
so characters having same attack will not override the max value
because qn is character having same attack will not be count as weak

 */