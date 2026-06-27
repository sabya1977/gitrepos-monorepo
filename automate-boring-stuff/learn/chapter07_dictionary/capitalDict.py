world_capital = {'France': 'Paris','Germany': 'Berlin', 'Russia': 'Moscow', 'China': 'Beijing'}
def list_capital():
    for k, v in world_capital.items():
        print('Capital of ' + str(k) + ' is ' + str(v))

def search_capital (arg_country):
    if arg_country in world_capital:
        print('Capital of ' + arg_country + ' is ' + world_capital[arg_country])
    else:
        print('Country name not found in the database')
        ch = input('Do you want to update? ')
        if ch == 'Y' or ch == 'y':
            capital = input ('Enter Capital name: ')
            world_capital[arg_country]= capital
            print('Capital of ' + arg_country + ' is updated to ' + world_capital[arg_country])

argc = input('Enter country name: > ')
search_capital(argc)
list_capital()