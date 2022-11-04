Bipartite graph:
* if graph can be colored in 2 colors then it is said to be bipartite
* if graph has no cycle then it is bipartite
* if graph has cycle of even then it is bipartite
* if graph has cycle of odd then it is not bipartite
​
Algorithm to find bipartite
1. start from root node color it as 0
2. visit all the adjacent nodes
3. if adj node already visited and has same color as current node then return false
```
if color[adj]==color[front]:
return false;
```
4. if adj node is not colored then color it as opposite of current node
```
if color[adj]==-1
color[adj] = color[front]^1 // opposite of current color
```
​