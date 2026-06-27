# raising exception on condition
import os
os.system('cls')
def shape (symb, width, height):
    if len(symb) != 1:
        raise Exception ('Symbol length must be exactly 1 byte')
    if width <= 1:
        raise Exception ('width must be greater than 1')
    if height <= 1:
        raise Exception ('height must be greater than 1')
    
    print(symb * width)    
    for i in range(height):
        print(symb + ' ' * (width-2) + symb)
    print(symb * width)    

try:
    symbol = input('Enter symbol for the shape> ')
    width = int(input('Enter width of the shape> '))
    height = int(input('Enter height of the shape> '))
    shape(symbol,width,height)
except Exception as error:
    print('An error has occured => ' + str(error))    



    
