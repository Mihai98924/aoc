def part1(data):
    num = 0
    for d in data:
        number = ""
        for j in range(len(d)):
            if d[j].isdigit():
                number += d[j]
        num += int(number[0] + number[-1])
    return num


numStrings = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']


def part2(data):
    num = 0
    for d in data:
        numbers = []
        for n in numStrings:
            m = 0
            while m < len(d):
                if n in d[m:] and :
                    numbers.append([numStrings.index(n) + 1, d[m:].index(n)])
                    m = d.index(n) + 1
                else:
                    m+=1
        for i in range(len(d)):
            if d[i].isdigit():
                numbers.append([int(d[i]), i])
        numbers.sort(key=lambda x: x[1])
        print(numbers)
        num += int(numbers[0][0] * 10 + numbers[-1][0])
    return num


with open("input.txt") as f:
    data = f.readlines()
    # print(part1(data))
    print(part2(data))
