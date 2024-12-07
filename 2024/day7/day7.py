
eqs = []

def backtrack(eq, index, s, result, concat=False):
    if index == len(eq):
        if int(s) == result:
            eqs.append(tuple(eq))
        return
    n = eq[index]
    backtrack(eq, index + 1, int(s) + n, result, concat)
    backtrack(eq, index + 1, int(s) * n, result, concat)
    if concat:
        backtrack(eq, index + 1, str(s) + str(n), result, concat)

def part2(lines):
    s = 0
    for l in lines:
        l[0] = int(l[0])
        eq = l[1].split(" ")
        l[1] = tuple([int(x) for x in eq])
        backtrack(l[1], 1, l[1][0], l[0], concat=True)
        if l[1] in eqs:
            s += l[0]
            print(l)
    print(s)

def part1(lines):
    s = 0
    for l in lines:
        l[0] = int(l[0])
        eq = l[1].split(" ")
        l[1] = tuple([int(x) for x in eq])
        backtrack(l[1], 1, l[1][0], l[0])
        if l[1] in eqs:
            s += l[0]
            print(l)
    print(s)

with open('input.txt') as f:
    lines = [line.strip().split(": ") for line in f.readlines()]
    # part1(lines)
    part2(lines)