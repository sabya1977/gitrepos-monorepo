classMarks = {'Sabyasachi': {'English': 88, 'Bengali': 89, 'Physics': 78, 'Chemistry': 90, 'Mathematics': 80},
              'Nancy': {'English': 93, 'Physics': 90, 'Chemistry': 77, 'Mathematics': 98},
              'Osman': {'English': 98, 'Physics': 86, 'Chemistry': 76, 'Mathematics': 97}}
for k, v in classMarks.items():
    totalMarks = 0
    print('----------------------------------------')
    print('      Mark sheet of: ' + str(k))
    print('----------------------------------------')
    print ('Subject ' + '                       ' + 'Marks')
    for x, y in v.items():
        print(str(x)[0:4] + '.                           ' + str(y))
        totalMarks +=y
    print('----------------------------------------')
    print('Total                           ' + str(totalMarks))
    print(' '*20)