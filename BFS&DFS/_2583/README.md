Problem:
Given M,N for the size of a paper(M x N), calculate the number of sections that are divided, and the size of the sections in ascending order.

Input:

First line: M (natural number <= 100) N (natural number <= 100) K (natural number <= 100)

Next K lines:
-	For each k line: position of left-bottom vertex of rectangle, position of right-top vertex of rectangle (x and y)
-	Ex) 0 2 4 4  (0,2) for left-bottom vertex and (4,4) for right-top vertex

Output:

First line: number of sections

Second line: size of sections in ascending order

Ex)
![20190428064022](https://user-images.githubusercontent.com/41462655/56863798-6e5f9900-6980-11e9-8f40-86e81c98fa9f.png)

From the image above, the input and output should be:

Input:
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

Output:
3
1 7 13
