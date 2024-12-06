
di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]

def bounds(x, y, matrix):
    if x < 0 or x >= len(matrix):
        return False
    if y < 0 or y >= len(matrix[0]):
        return False
    return True

def lee(matrix, x, y, loops=False):
    i = 0
    visited = []
    obstacles = []
    while bounds(x,y,matrix):
        if matrix[x][y] in '.^X':
            if loops:
                if ([x+di[i%len(di)],y+dj[i%len(dj)]],[x,y]) in obstacles:
                    return True
            t = list(matrix[x])
            t[y] = 'X'
            matrix[x]= ''.join(t)
            if [x,y] not in visited:
                visited.append([x,y])
            while bounds(x+di[i%len(di)],y+dj[i%len(dj)],matrix) and matrix[x+di[i%len(di)]][y+dj[i%len(dj)]] in 'O#':
                obstacles.append(([x + di[i % len(di)], y + dj[i % len(dj)]], [x, y]))
                i+=1
            x += di[i%len(di)]
            y += dj[i%len(dj)]
    return visited

def find_start(matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] == '^':
                return i,j

def part1(matrix):
    data = matrix.copy()
    i,j = find_start(data)
    queue = lee(data, i, j)
    return queue

def clean(matrix):
    for i in range(len(matrix)):
        matrix[i] = matrix[i].replace('X', '.').replace('O', '.')
    return matrix

def part2(matrix, queue):
    s = 0
    i, j = find_start(matrix)
    for q in queue:
        matrix = clean(matrix)
        matrix[i] = matrix[i][:j] + '^' + matrix[i][j+1:]
        if q == [i,j]:
            continue
        t = list(matrix[q[0]])
        t[q[1]] = 'O'
        matrix[q[0]] = ''.join(t)
        if lee(matrix, i, j, True) == True:
            print(s)
            s += 1
    print(s)


with open("input.txt") as f:
    matrix = f.readlines()
    matrix = [str(m.replace("\n", "")) for m in matrix]
    queue = part1(matrix)
    print(len(queue))
    part2(matrix, queue)


