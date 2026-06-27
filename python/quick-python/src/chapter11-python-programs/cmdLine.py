import sys
def main ():
    print("Command line script")
    for i in sys.argv[1:]:
        print(i)
main()