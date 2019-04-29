Problem:
--------------
Write a program that prints results from BFS and DFS search. If there are more than one vertex that can be visited, visit vertex with smaller numbers. If there are no more vertex to be visited, exit. vertex number starts from 1 to N.

Input:
--------------
First line: number of vertex (1<= N <= 1000), number of edges (1 <= M <= 10000), point to start with  
Next M lines: vertex that are connected (bidirectional)  

Output:
--------------
At first line, print the result of DFS  
At second line, print the result of VFS  

Example:
--------------
(1)  
Input:  
4 5 1  
1 2  
1 3  
1 4  
2 4  
3 4  

Output:  
1 2 4 3  
1 2 3 4  

(2)  
Input:  
5 5 3  
5 4  
5 2  
1 2  
3 4  
3 1  

Output:  
3 1 2 5 4  
3 1 4 2 5  

(3)  
Input:   
1000 1 1000  
999 1000  

Output:  
1000 999  
1000 999  


