Problem:
---
Bob has K wires, but wires have different lengths. Bob wants K wires with the same length by cutting K wires. For example, if Bob wants 140cm wires from 300cm wires, he has to cut 300cm wires and get 2 wires with length of 140cm, but has to waste 20cm of the wire.  

Write a program that prints the maximum length of wire that Bob can have with N wires when N (number of wires) is given.

Input:
--
First line: K N (K = total number of wires, N = number of wires needed, and K<=N)
                  1<=K<=10,000                1<=N<=1,000,000  

Next K lines: length of K wires in cm (length < (2^23-1))  

Output:
---
First line: Maximum length of N wires

Example:
--
(1)  
_Input:_  
4 11  
802  
743  
457  
539  

_Output:_  
200

Description:  
From 4 wires with length of 802cm, 743cm, 457cm, 539cm, Bob need to get 11 (N) wires.  
From the wire with length of 802cm, Bob can get 4 wires with length of 200cm.  
From the wire with length of 743cm, Bob can get 3 wires with length of 200cm.  
From the wire with length of 457cm, Bob can get 2 wires with length of 200cm.  
From the wire with length of 539cm, Bob can get 2 wires with length of 200cm.  
Thus, 11 wires with maximum length of 200cm

