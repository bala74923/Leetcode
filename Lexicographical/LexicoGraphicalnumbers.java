package Lexicographical;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LexicoGraphicalnumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(), curr= 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){// runs exactly n times
            list.add(curr);
            if(curr *10<=n ) curr*=10;
            else{
                if(curr>=n)curr/=10; // if curr is > n then only divide else not
                curr++;
                while(curr%10==0) curr/=10;
            }
        }
        System.out.println(list);
    }
}
