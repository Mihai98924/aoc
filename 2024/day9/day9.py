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


def part1(data):
    string = []
    files = 0
    for i in range(len(data)):
        if i % 2 == 0:
            string.extend([files] * int(data[i]))
            files += 1
        else:
            string += "".join(['.'] * int(data[i]))
    print([string[i] for i in range(len(string))])
    lt, rt = next_empty_spot(string, 0), last_filled_spot(string, len(string) - 1)
    while lt < rt:
        temp = string[rt]
        string[rt] = string[lt]
        string[lt] = temp
        lt, rt = next_empty_spot(string, lt + 1), last_filled_spot(string, rt - 1)
    print(checksum(string))


with open("input.txt") as f:
    data = f.readline().strip()
    part1(data)
