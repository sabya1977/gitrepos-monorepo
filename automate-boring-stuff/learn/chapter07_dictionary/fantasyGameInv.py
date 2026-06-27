stuff = {'rope':1, 'torch': 6, 'gold coin': 42, 'dagger': 1, 'arrow': 12}
def display_inventory(argstuff):
    items_total=0
    print('Inventory')
    for k, v in argstuff.items():
        items_total+=v
        print ('Item: ' + str(k) + ' number ' + str(v))
    print ("Total number of items " + str(items_total))

def fill_inventory(arglist):
    inv = {}
    for i in (range(len(arglist))):
        inv.setdefault(arglist[i],0)
        inv[arglist[i]] += 1
    return inv
def add_inventory (arg_inv, items_list):
    for i in (range(len(items_list))):
        arg_inv.setdefault(items_list[i], 0)
        arg_inv[items_list[i]] += 1

new_item_list = ['gold coin', 'dagger', 'gold coin', 'gold coin', 'ruby']
new_inv_list = fill_inventory(new_item_list)
display_inventory(new_inv_list)
print()
add_list = ['arrow', 'torch', 'rope', 'arrow', 'cap', 'gold coin']
add_inventory(new_inv_list, add_list)
display_inventory(new_inv_list)
