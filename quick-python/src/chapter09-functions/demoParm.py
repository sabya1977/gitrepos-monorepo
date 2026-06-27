# positional parameters
def power (num,exp):
    if exp == 0:
        return 1
    elif exp == 1:
        return num
    else:
        r = 1
        while exp > 0:
            r = r * num
            exp-=1
        return r
print(power(3,4))
# print(power(3)) # this will throw error
print(power(4,3)) # this will give unintended results
#
# passing parameters by arguments.
print(power(exp=4,num=3)) # order of arguments don't matter
#
# default value
def exp (num,exp=2):
    if exp == 0:
        return 1
    elif exp == 1:
        return num
    else:
        r = 1
        while exp > 0:
            r = r * num
            exp-=1
        return r

print(exp(3)) # by default exp takes 2 as exponential