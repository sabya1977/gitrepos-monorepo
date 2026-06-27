spam = ['tiger', 'monkey', 'lion', 'cat', 'dog', 'butterfly', 'human']
print(len(spam))
for i in (range(len(spam))):
    print (spam[i], end = " ")
# reverse
print("\n")
i = len(spam) -1
print ("reverse:", end=" ")
while (i >= 0):
    print(spam[i], end = " ")
    i-=1
print("\n")
for i in range(len(spam)-1, -1,-1):
    print(spam[i], end = " ")
#