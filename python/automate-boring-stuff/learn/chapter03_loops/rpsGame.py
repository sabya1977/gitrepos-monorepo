# rock, scissors and paper game
import random, sys, os
os.system('cls')
print ('Rock, Scissors and Paper game')
win = 0
loss = 0
ties = 0
while True: # main loop
    while True: # player move option loop
        print ('Enter your move: (r)ock, (p)aper, (s)cissor, (q)uit')
        playerMove = input('>')
        if playerMove == 'q':
            print('Your score %s Wins, %s Losses, %s Ties' % (win, loss, ties))
            sys.exit()
        elif playerMove == 'r' or playerMove == 'p' or playerMove == 's':
            break
        else:
            print('Invalid option!')
            continue
    if playerMove == 'r':
        print('You: ROCK')
    elif playerMove == 's':
        print('You: SCISSOR ')
    elif playerMove == 'p':
        print('You: PAPER')
    
    moveNumber = random.randint(1,3)
    if moveNumber == 1:
        computerMove = 'r'
        print ('Computer: ROCK')
    elif moveNumber == 2:
        computerMove = 's'
        print('Computer: SCISSOR')
    elif moveNumber == 3:
        computerMove = 'p'
        print('Computer: PAPER')
    
    if (computerMove == playerMove):
        print('It is a tie!')
        ties = ties +1
    elif (computerMove == 'r' and playerMove == 'p'):
        print ('You win!')
        win = win + 1
    elif (computerMove == 'r' and playerMove == 's'):
        print('You lose!')
        loss = loss + 1
    elif (computerMove == 's' and playerMove == 'p' ):
        print('You lose!')
        loss = loss + 1
    elif (playerMove == 'r' and computerMove == 'p'):
        print('You lose!')
        loss = loss + 1
    elif (playerMove == 'r' and computerMove == 's'):
        print('You win!')
        win = win + 1
    elif (playerMove == 's' and computerMove == 'p'):
        print('You win!')
        win = win + 1
    print('%s Wins, %s Losses, %s Ties' % (win, loss, ties))



    

