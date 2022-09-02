/*
    n=  100, output = 99
    from 1 to print number having larger digit sum
    i) if 2 elements have same digit sum print largest one
*/

#include<stdio.h>
#include<stdlib.h>
int sum(int n){
    int val=0;
    while(n!=0){
        val = val+(n%10);
        n/=10;
    }
    return val;
}

int main()
{
    int n ;
    scanf("%d",&n);
    int len = (int)(log10(n)+1);
    int lim = (int)pow(10,len-1);
    int canMax = (n/lim)-1;
    int val = (canMax*lim)+(lim-1);
    printf("%d",sum(val)>sum(n)?val:n);
    printf(":)");
    
}