import copy
def cityAdd(cityLst, cityName):
    cityLst.append(cityName)
    cityLst [0] = 'Bejing'
argList = ['Paris', 'Amsterdam', 'Rottedum', 'Berlin', 'Moscow']
cityList = copy.copy(argList)
city = 'Adelaide'
cityAdd(argList, city)
print (argList)
print(cityList)
