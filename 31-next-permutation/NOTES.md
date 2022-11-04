1. find the first arr[i]<arr[i+1] from the right
2. after the i ,arr[i+1,..n] are sorted in descending order
3. if i doesnt exist array is already in descending order so return reverse of array
4. else
5. get the element that satisifes the condition arr[i]<= arr[ele] && arr[ele]-arr[i] should be minimum ,if duplicate elements exist mark the last element that satisfies this condition to maintain the descending order property
6. now swap these two elements i, ele
7. now reverse array reverse(arr,i+1,n-1)
8. return the array
 
 intutution:
*   select the descending order you cannot make it more greater as it is already in descending order
*   so swap i with smallest ele that is arr[ele]>=arr[i]
*   now reverse the array from i+1,to n we get next permutation
