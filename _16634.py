'''
Created on 2019. 1. 15.

@author: donny
'''
inp = input().split()

code = inp[0]
msg = inp[1].strip()
result = ''
if code == 'E':
    tmp = ''
    count = 1
    for i in range(len(msg)):
        if tmp == '':
            tmp = msg[i]
            
            
        elif tmp != msg[i]:
            result += tmp + str(count)
            tmp = msg[i]
            count = 1
        elif tmp == msg[i]:
            count += 1
            
    result += tmp + str(count)
    print(result)
else:
    
    tmp = ''
    for i in range(len(msg)):
        if msg[i].isdigit():
            num = int(msg[i])
            result += str(tmp) * (num-1)
        else:
            tmp = msg[i]
            result += tmp
            
            
    print(result)   
            
            
    
    
    
