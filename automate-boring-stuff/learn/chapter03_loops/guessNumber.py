# number guess program
import random, os
os.system('cls')
print ('I am thinking a number....')
secretNumber = random.randint(1,20)
for i in range(1,7):
    print ('Guess a number between 1 and 20: ')
    guessNumber = int(input('>'))
    if guessNumber > secretNumber:
        print ('Guess number is too high')
    elif guessNumber < secretNumber:
        print ('Guess number is too low')
    else:
        print('You guessed the correct number!')
        print ('You got guess in '+ str(i) + ' guess')
        break
if guessNumber != secretNumber:
    print('You lost! the right guess was: '+ str(secretNumber))