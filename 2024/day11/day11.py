BLINKS = 25

def part1(data):
    for i in range(BLINKS):
        added = []
        for j in range(len(data)):
            if data[j] == "0":
                data[j] = str(1)
            elif len(data[j]) % 2 == 0:
                temp = data[j][len(data[j])//2:]
                data[j] = data[j][:len(data[j])//2]
                added.append(str(int(temp)))
            else:
                temp = int(data[j]) * 2024
                data[j] = str(temp)
        data.extend(added)
    print(len(data))




with open("input.txt") as f:
    data = f.readline().strip().split(" ")
    print(data)
    part1(data)
    # part2(lines)