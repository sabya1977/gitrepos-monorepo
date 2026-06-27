#lambda
func_d = {'f_to_c': lambda celcius: (celcius*1.8) + 32, 'c_to_f': lambda farenhit: (farenhit - 32)/1.8}
print(func_d['f_to_c'](22))