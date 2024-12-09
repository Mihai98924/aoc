
def bounds(x, y, matrix):
    if x < 0 or x >= len(matrix):
        return False
    if y < 0 or y >= len(matrix[0]):
        return False
    return True

def part2(lines):
    symbols = {}
    for i in range(len(lines)):
        for j in range(len(lines[i])):
            if lines[i][j] not in ".":
                if lines[i][j] not in symbols.keys():
                    symbols[lines[i][j]] = [(i, j)]
                else:
                    symbols[lines[i][j]].append((i, j))
    cnt = 0
    for s in symbols.keys():
        for i in range(len(symbols[s]) - 1):
            for j in range(i + 1, len(symbols[s])):
                for k in range(-len(lines), len(lines)):
                    v =  (symbols[s][i][0] + k * (symbols[s][i][0] - symbols[s][j][0]), symbols[s][i][1] + k * (symbols[s][i][1] - symbols[s][j][1]))
                    if bounds(v[0], v[1], lines) and lines[v[0]][v[1]] != "#":
                        lines[v[0]] = lines[v[0]][:v[1]] + "#" + lines[v[0]][v[1] + 1:]
    for i in range(len(lines)):
        for j in range(len(lines[i])):
            if lines[i][j] != ".":
                cnt += 1
    print(cnt)

def part1(lines):
    symbols = {}
    for i in range(len(lines)):
        for j in range(len(lines[i])):
            if lines[i][j] not in ".":
                if lines[i][j] not in symbols.keys():
                    symbols[lines[i][j]] = [(i, j)]
                else:
                    symbols[lines[i][j]].append((i, j))
    cnt = 0
    for s in symbols.keys():
        for i in range(len(symbols[s]) - 1):
            for j in range(i + 1, len(symbols[s])):
                v1 = (symbols[s][i][0] + (symbols[s][i][0] - symbols[s][j][0]), symbols[s][i][1] + (symbols[s][i][1] - symbols[s][j][1]))
                v2 = (symbols[s][j][0] + (symbols[s][j][0] - symbols[s][i][0]), symbols[s][j][1] + (symbols[s][j][1] - symbols[s][i][1]))
                if bounds(v1[0], v1[1], lines) and lines[v1[0]][v1[1]] != "#":
                    lines[v1[0]] = lines[v1[0]][:v1[1]] + "#" + lines[v1[0]][v1[1]+1:]
                    cnt += 1
                if bounds(v2[0], v2[1], lines) and lines[v2[0]][v2[1]] != "#":
                    cnt += 1
                    lines[v2[0]] = lines[v2[0]][:v2[1]] + "#" + lines[v2[0]][v2[1] + 1:]
    print(cnt)

with open("input.txt") as f:
    lines = [line.strip() for line in f.readlines()]
    # part1(lines)
    part2(lines)
