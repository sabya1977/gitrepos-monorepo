# escape characters
print ('say Hi to Bob\'s mother')
print ('Kashmit is called \"Paradise on Earth"')
print ("Hi Nancy, \n\nHow are you?\nI am doing fine\nThanks,\nSabya")
# precede backslah with a backslah to print it as backslah since blackslash is a escapre seq.
print ("File Path: C:\\Users\\sabya\\Appdata")
#
# raw strings
# raw strings ignores all escape characters
print (r'File Path (raw strings): C:\Users\sabya\Appdata\Roaming')
# multi-line string
print (""" Hi Derby, 
        How are you?
        I am doing fine
        Thanks,""")
# indexes and slices
# a string has positive and negative indexing
# positive index: the first character's index is 0 and the last one's is the length -1
# negative index: the first character's index is -len(string) and last one's -1
greeting = 'Hello, world!'
print (greeting[-len(greeting)]) # will print H
print (greeting[-1]) # will print !
# in the below code snippet, the range function will start from 0
# and loop upto length of the strings, which is 13 (but not including 13)
for i in (range(len(greeting))):
    print(greeting[i], end='')
#
print ('\n')
# reverse printing without using reverse function
# note that you must provide a negative step value for
# the below loop to work because default step value is +1
for i in range(-1, -14, -1):
    print(greeting[i], end='')
#
# String formatting mechanism in Python
# F-strings
fname = 'Sabyasachi'
lname = 'Mitra'
age = 48
city = 'Hyderabad'
state = 'Telengana'
print('\n')
print (f'My name is {fname + ' ' + lname}, my age is {age} and I live in {city} and my state is {state}')
#
# F-String Alternatives: %s and format()
fullname = fname + ' ' + lname
print ('My name is %s %s, my age is %s and I live in %s and my state is %s' % (fname, lname, age, city, state))
#
# string formatting with format function
print('My name is {} {}, my age is {}, I live in {} and my state is {}'.format(fname, lname, age, city, state))
#
christ = 'Jesus'
year = '2200'
place = 'Bethelehelm'
print ('{0} was born {1} years ago in {2}'.format(christ, year, place))
#
# Checking String Characteristics
# age = input('Enter your age: ')
# if age.isdecimal():
#     print('Your age is', age)
# else:
#     print('invalid age: age contains letters')
#
# Joining and Splitting Strings
fname = 'Sabyasachi'
lname = 'Mitra'
name = ' '.join(['My', 'name', 'is', fname, lname])
print(name)
str = 'Sabyasachi Mitra 48 Hyderabad'
lstr = str.split()
print(lstr)
str = 'Sabyasachi,Mitra,48,Hyderabad'
lstr = str.split(',')
print(lstr)
for i in range(len(lstr)):
    print (lstr[i])
#
#Justifying and Centering Text
name = 'Sabyasachi Mitra'
print(name.rjust(40))
print(name.rjust(40, '-'))
print(name.ljust(40,'*'))
print(name.center(35, '-'))