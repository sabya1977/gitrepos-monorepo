import logging
# disabling CRITICAL (highest level) will disable all levels of debugging levels
logging.disable(logging.CRITICAL) # disable logging of level CRITICAL and below
logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(levelname)s - %(message)s')
logging.debug('Start of program')
def factorial(n):
    logging.debug('Start of factorial(' + str(n) + ')')
    total = 1
    for i in range(n+1):
        total*=i
        logging.critical('i is ' + str(i) + ', total is ' + str(total))
        logging.debug('i is ' + str(i) + ', total is ' + str(total))
    logging.debug('End of factorial(' + str(n) + ')')
    return total

print(factorial(5))
logging.debug('End of program')
