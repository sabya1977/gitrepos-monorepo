v = 10
def f(x):
    """f: scope test function"""
    print("global: ", list(globals().keys()))
    print("Entry locals: ", locals())
    y = x
    w = v
    print("Exit locals: ", locals())