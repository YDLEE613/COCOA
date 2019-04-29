
Problem:
--------------
A virus is leaked out in a lab, but it hasn’t spread yet and we are trying to build walls to prevent it from spreading. The size of lab is N x M. The lab is with empty spaces and walls. There are viruses in some spaces, and those viruses can spread in 4 directions (left, right, up, down). The number of walls that can be built is limited to 3 only.

0 represents empty space.  
1 represents a wall.  
2 represents virus.

Lab:   
2 0 0 0 1 1 0  
0 0 1 0 1 2 0  
0 1 1 0 1 0 0  
0 1 0 0 0 0 0  
0 0 0 0 0 1 1  
0 1 0 0 0 0 0  
0 1 0 0 0 0 0  

From the lab above, if a wall is not built, viruses (represented with 2) can spread and fill the entire lab.  
The lab after building 3 walls at index position (0,1), (1,0) and (3,5):  
2 1 0 0 1 1 0  
1 0 1 0 1 2 0  
0 1 1 0 1 0 0  
0 1 0 0 0 1 0  
0 0 0 0 0 1 1  
0 1 0 0 0 0 0  
0 1 0 0 0 0 0  

If the virus spreads in the lab with 3 walls built, the lab becomes:  
2 1 0 0 1 1 2  
1 0 1 0 1 2 2  
0 1 1 0 1 2 2  
0 1 0 0 0 1 2  
0 0 0 0 0 1 1  
0 1 0 0 0 0 0  
0 1 0 0 0 0 0  

After building 3 walls, the spaces that the virus can’t spread are called “safe” spaces. The number of safe spaces from above lab is 27. 
When the map of lab is given, calculate the number of “safe” spaces.  

Input:
--------------
First line: N M ( 3<=N, M <= 8)  
Next N lines: map of lab.   

2<= Number of 2 (virus) <= 10  
3 <= Number of empty spaces  

Output:
--------------
Number of “safe” spaces after viruses are spread.


Examples:
--------------
Input(1):  
7 7  
2 0 0 0 1 1 0  
0 0 1 0 1 2 0  
0 1 1 0 1 0 0  
0 1 0 0 0 0 0  
0 0 0 0 0 1 1  
0 1 0 0 0 0 0  
0 1 0 0 0 0 0

Output(1):   
27  


Input(2):  
4 6  
0 0 0 0 0 0  
1 0 0 0 0 2  
1 1 1 0 0 2  
0 0 0 0 0 2  

Output(2):  
9  

Input(3):  
8 8  
2 0 0 0 0 0 0 2  
2 0 0 0 0 0 0 2  
2 0 0 0 0 0 0 2  
2 0 0 0 0 0 0 2  
2 0 0 0 0 0 0 2  
0 0 0 0 0 0 0 0  
0 0 0 0 0 0 0 0  
0 0 0 0 0 0 0 0  

Output(3):  
3  
