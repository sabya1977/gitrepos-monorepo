# print function - variation
# take input date and format and print
import os
os.system('cls')
dd = int(input('Enter day> '))
mm = int(input('Enter month> '))
yy = int(input('Enter year> '))
fmt = input ('Enter format> ')
print ('You entered', end=' ')
print (dd, mm, yy, sep=fmt)
