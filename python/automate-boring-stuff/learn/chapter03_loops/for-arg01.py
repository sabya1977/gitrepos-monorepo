# for loop with aurguements
import os
os.system('cls')
print ("Example 1")        
start = 10
end = 20
for i in range(start, end):
    if i%2 ==0:
        print(i, " is even")
    else:
        print (i, " is odd")
print ("Example 2")        
#
start = 10
end = 20
step = 2
for i in range(start, end, step):
    if i%2 == 0:
        print(i, " is even")
    else:
        print (i, " is odd")