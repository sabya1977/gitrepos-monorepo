import os, sys
os.system('cls')
names = []
while True:
    ch = input ('\nEnter option: (a)dd, (d)elete, (s)earch, (o)rder, (p)rint, (q)uit)> ')
    match ch:
        case 'q':
            break
        case 'a':
            name = input ('Enter name to add> ')
            if name == '':
                break
            else:
                names.append(name)
        case 's':
            name = input('Enter name to search> ')
            try:
                srch_name = names.index(name)
                print(names[srch_name] + ' found!')
            except ValueError:
                print("Name you entered not found in the list")
        case 'd':
            name = input ('Enter name to delete> ')
            try:
                names.remove(name)
                print (name + ' deleted from the list')
            except ValueError:
                print("Name you entered not found in the list")
        case 'o':
            for i in range(len(names)):
                print ("Before sorting ", end=" ")
                print(names[i], end=" ")
            print("\n")
            names.sort()
            for i in range(len(names)):
                print ("After sorting ", end=" ")
                print(names[i], end=" ")
        case 'p':
            for i in range(len(names)):
                print(names[i], end=" ")




