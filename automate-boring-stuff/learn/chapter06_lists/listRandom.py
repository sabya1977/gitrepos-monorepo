import random
card_suits = ['Clubs ','Diamonds','Hearts', 'Spades ']
card_rank = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
for i in (range(4)):
    print(random.choice(card_rank), random.choice(card_suits))
#
random.shuffle (card_suits)
random.shuffle (card_rank)
print(card_suits, end=" ")
print("\n")
print(card_rank, end=" ")