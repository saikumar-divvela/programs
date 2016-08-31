''' This is  "nester.py:" module  which includes a function print_lol to print list
which may or may not include other lists'''

def print_lol(items,level=0):
    for item in items:
        if isinstance(item,list):
            print_lol(item,level+1)
        else:
            for tab_stop in range(level):
                print("\t",end="")
            print(item)
