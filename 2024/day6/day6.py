
di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]

queue = []

def bounds(x, y, matrix):
    if x < 0 or x >= len(matrix):
        return False
    if y < 0 or y >= len(matrix[0]):
        return False
    return True

def lee(matrix, x, y):
    i = 0
    while bounds(x,y,matrix):
        if matrix[x][y] == '.' or matrix[x][y] == '^' or matrix[x][y] == 'X':
            if bounds(x+di[i%len(di)],y+dj[i%len(dj)],matrix) and matrix[x+di[i%len(di)]][y+dj[i%len(dj)]] == '#':
                i+=1
            t = list(matrix[x])
            t[y] = 'X'
            matrix[x]= ''.join(t)
            if [x,y] not in queue:
                queue.append([x,y])
            x += di[i%len(di)]
            y += dj[i%len(dj)]
    for m in matrix:
        print(m)


def part1(data):
    for i in range(len(data)):
        for j in range(len(data[i])):
            if data[i][j] == '^':
                lee(data, i, j)
                break
    print(len(queue))

with open("input.txt") as f:
    matrix = f.readlines()
    matrix = [str(m.replace("\n", "")) for m in matrix]
    part1(matrix)

