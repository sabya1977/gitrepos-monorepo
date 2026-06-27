# Generator functions
def even_num():
    # lst = list(map(lambda x: x ** 1, range(1, 40)))
    for x in range(1,40):
        if x % 2 == 0:
            yield x
for i in even_num():
    print(f"Even numbers between 1 and 40 is {i}")
