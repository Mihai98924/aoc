
di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]


def check_bounds(i, j, data):
    if i < 0 or i >= len(data):
        return False
    if j < 0 or j >= len(data[i]):
        return False
    return True

def get_trail(i,j,data, trail):
    if int(data[i][j]) == 9:
        trail.add((i,j))
        return True
    for i in range(len(di)):
        if check_bounds(i+di[i], j+dj[i], data) and int(data[i+di[i]][j+dj[i]]) == int(data[i][j]) + 1:
            trail.add((i,j))
            get_trail(i+di[i], j+dj[i], data, trail)

def part1(data):
    trail = set()
    for i in range(len(data)):
        for j in range(len(data[i])):
            if data[i][j] == '0':
                get_trail(i,j,data, trail)
                break
    print(trail)

with open("input.txt") as f:
    lines = [line.strip() for line in f.readlines()]
    part1(lines)