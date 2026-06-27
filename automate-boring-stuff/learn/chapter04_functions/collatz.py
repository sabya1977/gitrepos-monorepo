# simulating collarz sequence
import os, sys
os.system('cls')
def seqCollatz (argNumber):
    if argNumber%2 == 0:
        return argNumber // 2
    else:
        return 3 * argNumber + 1
collatzNbr = 0
collatzNbr = int(input('Enter number> '))
if collatzNbr == 0:
    print ('Collatz sequence is only defined for positive integer!')
    sys.exit()
while True:
    print(collatzNbr, end=' ')
    if collatzNbr == 1:
        break
    collatzNbr = seqCollatz(collatzNbr)
    