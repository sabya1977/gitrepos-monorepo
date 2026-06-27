# salary arguement has a default value 
# default arguement must follow a non-default arguement
# because 
import os
os.system('cls')
def calculateComm (salesAmt, salary=10000):
    if salary > 5000:
        if salesAmt > 1000:
            return salesAmt * 0.2
        else:
            salesAmt * 0.1
    else:
        if salesAmt > 1000:
            return salesAmt * 0.3
        else:
            return salesAmt * 0.4

print ('Commission amount: ', calculateComm(2000,1500))
print ('Commission amount: ', calculateComm(2000))


