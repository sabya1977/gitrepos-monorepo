# while with break and continue
while True:
    print("Enter user name: ")
    user = input('>')
    print ("Enter password: ")
    password = input('>')
    if user == 'Joe':
        if password == 'joepass':
            print('Access garnted')
            break
        else:
            continue
    elif user == 'Mike':
        if password == 'mikepass':
            print('Access garnted')
            break
        else:
            continue
    else:
        print("Invalid user")
        break
print ('Thank you')

        
    