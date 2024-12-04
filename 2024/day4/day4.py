XMAS = 'XMAS'
MAS = 'MAS'
OPTIONS1 = [[[0, 0], [0, 1], [0, 2], [0, 3]], [[0, 0], [1, 0], [2, 0], [3, 0]], [[0, 0], [1, 1], [2, 2], [3, 3]],
            [[0, 0], [1, -1], [2, -2], [3, -3]]]
OPTIONS2 = [[[0, 0], [1, 1], [2, 2]], [[0, 0], [1, -1], [2, -2]]]


def check_bounds(i, j, data):
    if i < 0 or i >= len(data):
        return False
    if j < 0 or j >= len(data[i]):
        return False
    return True


def get_options(i, j, data, OPTIONS=OPTIONS1, TERM=XMAS):
    options = []
    for option in OPTIONS:
        temp = ""
        for o in option:
            if check_bounds(i + o[0], j + o[1], data):
                temp += (data[i + o[0]][j + o[1]])
        if temp == TERM or temp == TERM[::-1]:
            options.append([temp, [i, j, OPTIONS.index(option)]])

    return options

def get_cross(i, j, data, OPTIONS=OPTIONS2, TERM=XMAS):
    cross = []
    side_1 = ""
    for o in OPTIONS2[0]:
        if check_bounds(i + o[0], j + o[1], data):
            side_1 += (data[i + o[0]][j + o[1]])
    if side_1 == TERM or side_1 == TERM[::-1]:
        side_2 = ""
        for o in OPTIONS2[1]:
            if check_bounds(i + o[0], j + 2 + o[1], data):
                side_2 += (data[i + o[0]][j + 2 + o[1]])
        if side_2 == TERM or side_2 == TERM[::-1]:
            cross.append([side_1, side_2, [i, j]])
    return cross


def part1(data):
    cnt_xmas = []
    for i in range(len(data)):
        for j in range(len(data[i])):
            if data[i][j] == 'X' or data[i][j] == 'S':
                options = get_options(i, j, data)
                cnt_xmas.extend(options)
    print(len(cnt_xmas))

def part2(data):
    cnt_x_mas = []
    for i in range(len(data)):
        for j in range(len(data[i])):
            if data[i][j] == 'M' or data[i][j] == 'S':
                options = get_cross(i, j, data, OPTIONS2, MAS)
                cnt_x_mas.extend(options)
    print(len(cnt_x_mas))

with open('input.txt') as f:
    data = f.readlines()
    part1(data)
    part2(data)
