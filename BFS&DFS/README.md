Problem:
Write a program that prints results from BFS and DFS search. If there are more than one points that can be visited, visit points with smaller numbers. If there are no more points to be visited, exit. Point number starts from 1 to N.

Input: 
First line: number of points (1<= N <= 1000), number of edges (1 <= M <= 10000), point to start with
Next M lines: points that are connected (bidirectional)

Output:
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
At first line, print the result of DFS.
At second line, print the result of VFS

Example:
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

(3):
Input: 
1000 1 1000
999 1000
Output:
1000 999
1000 999


