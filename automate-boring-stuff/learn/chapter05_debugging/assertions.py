# assertions
ages = [15,23, 17, 90, 100, 210, 111]
ages.sort()
for i in range(len(ages)):
    print (ages[i], end=',')
ages.sort()
print(end='\n')
for i in range(len(ages)):
    print (ages[i], end=',')
# assert is for catching programmer error
# don't use it for catching user/data/file/db error
assert ages[-1] <= ages[0]
