import copy
def shallowfunc(arg, arglist):
    arglist[0][0] = arg
    print("Value of arglist inside the function ", end="")
    print(arglist)

arglist = [['Apple', 'Pinnaple'], ['Banana', 'Grape']]
arg='NewItem-00'
shallowlist = copy.copy(arglist)
print('Before function call->', arglist)
shallowfunc(arg, arglist)
print("Value changed inside the function reflects in shallowlist if it's a nested list")
print('After function call->', shallowlist)
