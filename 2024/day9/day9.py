def next_empty_spot(array, pos):
    for i in range(pos, len(array)):
        if array[i] == '.':
            return i
    return -1


def last_filled_spot(array, pos):
    for i in range(pos, 0, -1):
        if array[i] != '.':
            return i
    return -1


def checksum(data):
    s = 0
    for i in range(len(data)):
        if data[i] != '.':
            s += int(data[i]) * i
    return s

def decompose(data, part_2=False):
    string = []
    files = 0
    info = []
    spaces = []
    for i in range(len(data)):
        if i % 2 == 0:
            info.append((len(string), int(data[i]), files))
            string.extend([files] * int(data[i]))
            files += 1
        else:
            if int(data[i]) != 0:
                spaces.append((len(string), int(data[i])))
            string += "".join(['.'] * int(data[i]))
    if part_2:
        return string, info, spaces
    else:
        return string

def find_spaces(string):
    spaces = []
    for i in range(len(string)):
        if string[i] == '.':
            for j in range(i + 1, len(string)):
                if string[j] != '.':
                    spaces.append((i, j - i))
                    break
    return spaces

def lower_space(spaces, ind):
    for i in range(len(spaces)):
        if spaces[i][0] < ind[0] and spaces[i][1] >= ind[1] :
            return True
    return False

def part2(data):
    string, info, spaces = decompose(data, True)
    # print(string, info, spaces)
    inds = 0
    indi = len(info) - 1
    while string[-1] != '.':
        if spaces[inds][1] >= info[indi][1]:
            for i in range(info[indi][0], info[indi][0] + info[indi][1]):
                temp = string[i]
                string[i] = string[spaces[inds][0] + i - info[indi][0]]
                string[spaces[inds][0] + i - info[indi][0]] = temp
            spaces[inds] = (spaces[inds][0] + info[indi][1], spaces[inds][1] - info[indi][1])
            info.remove(info[indi])
            indi -= 1
            spaces = find_spaces(string)
            if spaces[inds][1] == 0:
                indi = len(info) - 1
                spaces = find_spaces(string)
        elif spaces[inds][1] < info[indi][1]:
            indi -= 1
            spaces = find_spaces(string)
        if indi < 0:
            inds = 0
            spaces = find_spaces(string)
            indi = len(info) - 1
    print(string)
    print(checksum(string))

def part1(data):
    string = decompose(data)
    lt, rt = next_empty_spot(string, 0), last_filled_spot(string, len(string) - 1)
    while lt < rt:
        temp = string[rt]
        string[rt] = string[lt]
        string[lt] = temp
        lt, rt = next_empty_spot(string, lt + 1), last_filled_spot(string, rt - 1)
    print(checksum(string))


with open("input.txt") as f:
    data = f.readline().strip()
    part2(data)
