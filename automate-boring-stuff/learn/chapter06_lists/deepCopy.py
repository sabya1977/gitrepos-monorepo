import copy
def deepcopyfunc(arg, arglist):
    arglist[0][0] = arg
    print("Value of arglist inside the function ", end="")
    print(arglist)

arglist = [['Apple', 'Pinnaple'], ['Banana', 'Grape']]
arg='NewItem-00'
deepcpylist = copy.deepcopy(arglist)
print('Before function call->', arglist)
deepcopyfunc(arg, arglist)
print("Value changed inside the function didn't reflect in deepcpylist if it's a nested list")
print('After function call->', deepcpylist)