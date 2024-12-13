di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]


def check_bounds(i, j, data):
    if i < 0 or i >= len(data):
        return False
    if j < 0 or j >= len(data[i]):
        return False
    return True


def get_trail(i, j, data, trail):
    trail.add((i, j))
    if check_bounds(i + di[0], j + dj[0], data) and int(data[i + di[0]][j + dj[0]]) == int(data[i][j]) + 1:
        get_trail(i + di[0], j + dj[0], data, trail)
    if check_bounds(i + di[1], j + dj[1], data) and int(data[i + di[1]][j + dj[1]]) == int(data[i][j]) + 1:
        get_trail(i + di[1], j + dj[1], data, trail)
    if check_bounds(i + di[2], j + dj[2], data) and int(data[i + di[2]][j + dj[2]]) == int(data[i][j]) + 1:
        get_trail(i + di[2], j + dj[2], data, trail)
    if check_bounds(i + di[3], j + dj[3], data) and int(data[i + di[3]][j + dj[3]]) == int(data[i][j]) + 1:
        get_trail(i + di[3], j + dj[3], data, trail)


def part1(data):
    starts = []
    answer = 0
    for i in range(len(data)):
        trail = set()
        for j in range(len(data[i])):
            if data[i][j] == '0':
                starts.append((i, j))
    for s in starts:
        trail = set()
        get_trail(s[0], s[1], data, trail)
        results = [(i, j) for i, j in trail if data[i][j] == '9']
        answer += int(len(results))
    print(answer)
    # get_trail(0,2,data, trail)
    # view = [[0 for _ in range(len(data[0]))] for _ in range(len(data))]
    # for i,j in trail:
    #     view[i][j] = int(data[i][j])
    # for v in view:
    #     print(v)


with open("input.txt") as f:
    lines = [line.strip() for line in f.readlines()]
    part1(lines)
