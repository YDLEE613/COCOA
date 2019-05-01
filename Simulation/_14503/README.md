Problem:
---
Given a robot vacuum, calculate the number of cleaned sections.

The room is represented by N x M and divided into 1 x 1 square sections. Every section is either wall or empty space. The robot vacuum has direction, which is one of East, West, South, and North. Every section of the room can be represented by (r,c), and r is the number of sections from the north, and c is the number of sections from the west.

The robot vacuum operates in the following order:    
1. Clean current section.  
1. From current section, begin cleaning from the left side of current direction.  
    1. If there are sections that are not cleaned yet in left side, rotate 90 degree counter-clockwise and move forward. Begin from 1.  
    1. If there are no sections to clean in the left side, just rotate 90 degree counter-clockwise and begin from 2.  
    1. If every side of the current location (section) of robot vacuum is either cleaned or a wall, move 1 sections backword, maintaining the same direction. Begin from 2.  
    1. If every side of the current location (section) of robot vacuum is either cleaned or a well, and if the robot vacuum can't go backward because it is wall, stop operating.  

The robot vacuum does not clean the cleaned section, and can't go through walls.
 
 
Input:
---
First line: N(column) x M(row)  (3<=N,M<=50)
Second Line: r c d  ((r,c): current location of robot vacuum, d: direction the robot is toward to)  
  * 0: north
  * 1: east
  * 2: south
  * 3: west
  
Next N lines: The room. 0 represents empty, and 1 represents wall.
  
The initial location of the vacuum is always empty.
  
Output:
---
First line: The number of sections the vacuum cleaned.
  
Example:
---
(1)  
_Input:_  
3 3  
1 1 0  
1 1 1  
1 0 1  
1 1 1  

_Output:_
1  

(2)  
_Input:_  
11 10  
7 4 0  
1 1 1 1 1 1 1 1 1 1  
1 0 0 0 0 0 0 0 0 1  
1 0 0 0 1 1 1 1 0 1  
1 0 0 1 1 0 0 0 0 1  
1 0 1 1 0 0 0 0 0 1  
1 0 0 0 0 0 0 0 0 1  
1 0 0 0 0 0 0 1 0 1  
1 0 0 0 0 0 1 1 0 1  
1 0 0 0 0 0 1 1 0 1  
1 0 0 0 0 0 0 0 0 1  
1 1 1 1 1 1 1 1 1 1  

_Output:_
57  
