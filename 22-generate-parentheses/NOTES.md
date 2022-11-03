# logic
no of parantheses to be generated n
so open will go from n to 0, indicates remaining number of open parantheses to be generated from current state
Here close - represents no of parantheses are open
​
in One step we can open a parantheses or close a paranthes and we know these recursions will end when string reaches its length 2*n
```
rec(open,close,index){
//no of parantheses -> n,so possible length of valid string is 2*n
if(index==2*n){
list.add(string)
return
}
if(open>0) // if some parantheses still need to be open
{
str[index] = '('
rec(open-1,close+1,index+1) // so one parantheses is openend but another parantheses need to close
// now so make it close+1
}
if(close>0){
str[index] = ')'
rec(open,close-1,index+1) // one parantheses is closed now so close-1
}
}
```
​
​