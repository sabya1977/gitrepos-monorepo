def f(x):
    print("Entry locals ", locals())
    print("Entry globals ", globals())
    y = x
    print("Exit locals ", locals())
    print("Exit globals ", globals())
a=2
f(a)