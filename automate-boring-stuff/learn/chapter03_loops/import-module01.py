# random module usage
import random, sys, os
os.system('cls')
for i in range (10):
    print(random.randint(1,10))
# example of sys.exit()
os.system('cls')
while True:
    print("Enter city: ")
    response = input ('>')
    response = response.lower()
    if response == 'quit':
        sys.exit()
    else:
        if response.title() == 'Paris':
            print (response.title(), ' capital of France')
            continue
        elif response.title() == 'Washington':
            print (response.title(), ' capital of USA')
            continue
        elif response.title() == 'London':
            print (response.title(), ' capital of United Kingdom')
            continue
        elif response.title() == 'Brussels':
            print (response.title(), ' capital of Belgium')
            continue
        elif response.title() == 'Moscow':
            print (response.title(), ' capital of Russia')
            continue
        elif response.title() == 'Berlin':
            print (response.title(), ' capital of Germany')
            continue
        elif response.title() == 'Amsterdam':
            print (response.title(), ' capital of the Netherlands')
            continue
        else:
            print ("Capital not found")
            continue
