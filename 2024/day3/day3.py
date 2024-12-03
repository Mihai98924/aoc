import re

def part1(data):
    pattern = r'mul\((\d{1,3}),(\d{1,3})\)'
    result = 0
    for d in data:
        matches = re.findall(pattern, d)
        products = [int(m[0]) * int(m[1]) for m in matches]
        result += sum(products)
    return result

def part2(data):
    pattern = r'(mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don\'t\(\))'
    result = 0
    for d in data:
        matches = re.findall(pattern, d)
        print(matches)
        break

with open("input.txt") as f:
    data = f.readlines()
    print(part1(data))
    part2(data)