charList = ['A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i','j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ',', '.', '-', '/', ' ']
message = 'It was a bright cold day in April, and the clocks were striking thirteen.'
charCount = {}
for i in range(len(charList)):
    for char in message:
        if charList[i] == char:
            charCount.setdefault(charList[i], 0)
            charCount[charList[i]] = charCount[charList[i]] + 1
        else:
            charCount.setdefault(charList[i], 0)
for k, v in charCount.items():
    if k == ' ':
        k = 'Space'
    print ('Character = ' + k + ' Count = ' + str(v) )
