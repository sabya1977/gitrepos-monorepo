# List comprehension is an elegant way to define and create a list in Python
lst = [x**2 for x in range(1,10)]
print(lst)
lst = [x**2 for x in range(1,10) if x%2 == 1] # with condition
print(lst)
#
# List comprehension with lambda
lst = list(map(lambda x: x**2, range(1,10)))
print(lst)
#
# Create a new modified list from an existing list by lambda
list_ = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
lst = list(map(lambda x: x**2, list_))
print(lst)
#
# Using filter function
