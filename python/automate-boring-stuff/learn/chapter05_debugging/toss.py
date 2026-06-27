import random
guess = ''
while True:
    print('Guess the coin toss! Enter H/T or q to quit:')
    guess = input()
    if guess == 'q':
        break
    match random.randint(0, 1):
        case 0:
            toss = 'H'
        case 1:
            toss = 'T'
    if (toss == guess.upper()):
        print ('You won the toss!')
    else:
        print('You lose the toss!')