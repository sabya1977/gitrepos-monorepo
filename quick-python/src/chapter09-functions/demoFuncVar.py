#Assigning functions to variables
def c_to_farenhit(celcius):
    return (celcius*1.8) + 32
def f_to_celcius(farenhit):
    return (farenhit - 32)/1.8

celcius = 32
abs_temperature = c_to_farenhit
print(f"{celcius} degree Celsius is {abs_temperature(celcius)} Fahrenheit")
abs_temperature = f_to_celcius
Fahrenheit = 50
print(f"{Fahrenheit} degree Fahrenheit is {abs_temperature(Fahrenheit)} Fahrenheit")
#
# storing functions in dictionary
func_d = {'f_to_c':f_to_celcius, 'c_to_f': c_to_farenhit}
for i in func_d.keys():
    match i:
        case 'f_to_c':
            print(func_d[i](23))
        case 'c_to_f':
            print(func_d[i](-7))
        case _:
            continue

