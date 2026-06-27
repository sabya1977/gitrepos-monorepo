animals = ['tiger', 'monkey', 'lion', 'cat', 'dog', 'butterfly', 'human']
# start from 1 and end at end -1 = 3
print(animals[1:4])
# start from 0 end at 6 index location, jump by 2
print(animals[0:7:2])
# end is ommited and ends at index location 6
print(animals[0:])
# start from 0 and end at index location 3
print(animals[:3])
# if start and end are empty and step is negative, the traversing
# start from the last element and go until the first element of the list
print(animals[::-1])
# if start and end are empty and step is positive, the traversing
# start from the first and go until the last element of the list
print(animals[::1])