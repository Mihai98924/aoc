import re

def products(matches):
    product = [int(m[1]) * int(m[2]) for m in matches]
    return sum(product)

def part1(data):
    pattern = r'(mul\((\d{1,3}),(\d{1,3})\))'
    result = 0
    for d in data:
        matches = re.findall(pattern, d)
        result += products(matches)
    return result

def part2(data):
    pattern = r'(mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don\'t\(\))'
    result = 0
    matches = []
    for d in data:
        matches.extend(re.findall(pattern, d)) # do's and don'ts can go to multiple lines
    counts = True
    for m in matches:
        if m[0] == "do()":
            counts = True
            continue
        elif m[0] == "don't()":
            counts = False
            continue
        if counts:
            result += int(m[1]) * int(m[2])
    return result

with open("input.txt") as f:
    data = f.readlines()
    print(part1(data))
    print(part2(data))