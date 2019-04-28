Problem
-
There is a sequence A_1, A_2, ..., A_N with __N__ numbers. There are __N-1__ arithmetic operators (+, -, x, /)

We can put operators bewteen numbers and can make mathematical expression. We can't change the order of numbers.

For example, a sequence with 6 numbers is 1,2,3,4,5,6, and when operators (two __+__, one __-__, one __x__, and one __/__) are given, we can make 60 mathematical expressions. 
* 1+2+3-4x5/6
* 1/2+3+4-5x6
* 1+2/3x4-5+6
* 1/2x3-4+5+6
* ...

We ignore the arithmetic operator order of precedence, and calculate from the beginning. We also only do integer division for / (just take quotient). From 4 expressions above, the results are:

* 1+2+3-4x5/6 = 1
* 1/2+3+4-5x6 = 12
* 1+2/3x4-5+6 = 5
* 1/2x3-4+5+6 = 7

When __N__ numbers and __N-1__ operators are given, calculate the min and max from all possible expressions.

Input
-
First line: N (2 <= N <= 11) - number of numbers

Second line: Sequence of numbers

Third line: list of number of operators ex) 1 2 3 4 --> one +, two -, three x, four /

Output
-
First line: maximum number
Second line: minimum number 

Any number after arithmetic operator are always less than or equal to 10 billion and greater than or equal to -10billion.


Examples
-
_Input(1):_

2

5 6

0 0 1 0

_Output(1):_

30

30

_Input(2):_

3

3 4 5

1 0 1 0

_Output(2):_

35

17

_Input(3):_

6

1 2 3 4 5 6

2 1 1 1

_Output(3):_

54

-24
