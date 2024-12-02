def odd_one_out(array):
    for i in range(len(array)):
        array_dup = array.copy()
        array_dup.pop(i)
        if safeLevel(array_dup):
            return True
    return False


def safeLevel(input):
    if not (sorted(input) == input or sorted(input, reverse=True) == input):
        return False
    for i in range(len(input) - 1):
        if not (1 <= abs(input[i] - input[i + 1]) <= 3):
            return False
    return True

def part1(input):
    return safeLevel(input)


def part2(input):
    if safeLevel(input):
        return True
    if odd_one_out(input):
        return True
    unsafeIndex = -1
    for i in range(len(input) - 1):
        if not (1 <= abs(input[i] - input[i + 1]) <= 3):
            unsafeIndex = i
            break
    dupinput = input.copy()
    dupinput.pop(unsafeIndex)
    if safeLevel(dupinput):
        return True
    return False


with open("input.txt") as file:
    data = file.readlines()
    number = 0
    for i in range(len(data)):
        data[i] = data[i].strip()
        input = data[i].split(' ')
        input = list(map(int, input))
        # part1(input)
        if part2(input):
            number += 1
        else:
            print(input, odd_one_out(input))
    print(number)
