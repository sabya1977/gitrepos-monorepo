# demonstrate indefinite number of positional parameters
def getmin(*numbers):
    if len(numbers) == 0:
        return 'getmin requires minimum 2 numbers'
    else:
        minimum = numbers[0]
        for i in numbers[1:]:
            if i < minimum:
                minimum = i
            else:
                continue
        return minimum
print(getmin(3,4,5,1,1,2))
print(getmin())
print(getmin(100,101))
#
# demonstrate indefinite number of keyword arguments
def example_fun(**other):
    for k, v in other.items():
        print(f"Parameter name {k}, Parameter value: {v}")
    other_total = 0
    for k in other.keys():
        other_total = other_total + other[k]
    print(f"The total of values in parameter list is {other_total}")
# print(example_fun(2, y="1", foo=3, bar=4))
print(example_fun(foo1=3, foo2=4, foo3=5))