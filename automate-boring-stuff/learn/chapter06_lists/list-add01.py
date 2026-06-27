names=[]
while True:
    print ("Enter Names: ")
    input_name = input ('> ')
    if input_name == '':
        break
    else:
        names = names + [input_name]
for i in range(len(names)):
    print (names[i])
new_names = names
print(new_names)
name1, name2, name3 = names
print (name1, end=" ")
print (name2, end=" ")
print (name3, end=" ")
