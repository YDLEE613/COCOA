
Problem:

A new virus spreads through network. If a computer is infected with the virus, other computers connected to the infected computer over network gets infected as well. 

![20190428064022](https://user-images.githubusercontent.com/41462655/56864357-19735100-6987-11e9-8343-40dc6019bf9c.png)


For example, from the image above, if computer #1 is infected, computer #2, #5, #3 and #6 get infected.
 Computer #4 and #7 are not infected because they are not connected with computer #1.

One day, computer #1 is infected.

Given the number of computers and the list of connected computers over network, get the number of infected computers.

Input:

First line: number of computers ( <=100)

Second line: number K of pair of connected computers

Next K lines: pair of connected computers

Output:

Print the number of infected computers if computer #1 is infected.


Example:

Input:

7

6

1 2

2 3

1 5

5 2

5 6

4 7

Output:

4

