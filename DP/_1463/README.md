Problem:
----------
There are three operations for integer X.

* If X is divisible by 3, divide X by 3.

* If X is divisible by 2, divide X by 2.

* Substract 1 from X.

If an integer X is given, use three operations above to make X one. Calculate the smalleset number of operations for X to be 1.

Input:
----
First line: X (1 <= X <= 10^6)

Output:
------
First line: Smallest number of operations for X to be 1.


Example:
--------
Input | Output
------|-------
2 | 1
10 | 3

In case of 10, 10 -> 9 -> 3 -> 1. Three operations are needed.
