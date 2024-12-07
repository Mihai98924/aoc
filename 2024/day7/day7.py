
eqs = set()

def backtrack(eq, index, s, result):
    if index == len(eq):
        if s == result:
            eqs.add(tuple(eq))
        return
    n = eq[index]
    backtrack(eq, index + 1, s + n, result)
    backtrack(eq, index + 1, s * n, result)

def part1(lines):
    s = 0
    for l in lines:
        l[0] = int(l[0])
        eq = l[1].split(" ")
        l[1] = tuple([int(x) for x in eq])
        backtrack(l[1], 1, l[1][0], l[0])
        if l[1] in eqs:
            s += l[0]
            print(l[1])
    print(s)

with open('input.txt') as f:
    lines = [line.strip().split(": ") for line in f.readlines()]
    part1(lines)