conside i th height as minimum height in its rectangle
so for this rectangle ,
let x is min height less than height[i] in left,start = x+1
let y is min height at right side[i], end = y-1
because if we include x andy then their values will be min height of this rectangle
now calculate area of this rectangle by height[i]* (rightMin[i]-leftMin[i]-1)
​
now do this for all N heights and return max