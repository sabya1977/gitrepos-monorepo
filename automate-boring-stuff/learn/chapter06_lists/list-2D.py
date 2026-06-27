name = 'Sabyasachi'
age = 48
matrix = [[None, None],[None, None]]
matrix[0][0] = name
matrix[0][1] = age
name = 'Ipshita'
age = 38
matrix[1][0] = name
matrix[1][1] = age
for x in range(2):
    for y in range (2):
        print(matrix[x][y], end=" ")
    print("\n")