# simulating collarz sequence with recursive function
# handle exception of non-integer input value
import os, sys
os.system('cls')
def seqCollatz (argNumber):
    if argNumber == 1:
        return 1
    if argNumber%2 == 0:
        print ((argNumber // 2), end=' ')
        return seqCollatz(argNumber // 2)
    else:
        print((3 * argNumber + 1), end=' ')
        return seqCollatz(3 * argNumber + 1)

try:
    collatzNbr = 0
    collatzNbr = int(input('Enter number> '))
    if collatzNbr == 0:
        print ('Collatz sequence is only defined for positive integer!')
        sys.exit()
    elif collatzNbr == 1:
        print (1)
    else:
        seqCollatz(collatzNbr)
except ValueError:
    print('You entered a non-integer value!')
    print('Collatz sequence is only defined for positive integer!')
    sys.exit()
    