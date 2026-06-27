from source.modules import mymodule

print(mymodule.pi)
print(mymodule.area(2)) # object defined inside module must be prefixed with module name
print(mymodule.__doc__)
print(mymodule.area.__doc__)