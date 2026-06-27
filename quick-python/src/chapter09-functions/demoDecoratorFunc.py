# Demonstrate decorator function
def decorate (func):
    print("in decorate function, decorating",
          func.__name__)
    def wrapper(*args):
        print("Executing", func.__name__)
        args = (args[0],) + (name_age.get(args[0]),)
        return func(args[0], args[1])
    return wrapper
name_age = {'Sabyasachi':48, 'John':42}
p_name = 'Sabyasachi'
p_age=0
@decorate
def decorated_func(name, age):
    print (f"Name {name}, age {age}")
decorated_func(p_name, p_age)
