BLINKS = 7

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

def part2(data):
    map = {}
    for d in data:
        if d not in map.keys():
            map[d] = 1
        else:
            map[d] += 1
    for i in range(BLINKS):
        changes = {}
        for k, v in map.items():
            if v > 0:
                if k == "0":
                    changes["0"] = (-1) * v
                    if "1" not in changes.keys():
                        changes["1"] = v
                    else:
                        changes["1"] += v
                elif len(k) % 2 == 0:
                    first_half = str(int(k[:len(k)//2]))
                    second_half = str(int(k[len(k)//2:]))
                    if first_half not in changes.keys():
                        changes[first_half] = v
                    else:
                        changes[first_half] += v
                    if second_half not in changes.keys():
                        changes[second_half] = v
                    else:
                        changes[second_half] += v
                    changes[k] = (-1) * v
                else:
                    if str(int(k) * 2024) not in changes.keys():
                        changes[str(int(k) * 2024)] = v
                    else:
                        changes[str(int(k) * 2024)] += v
                    changes[k] = (-1) * v
        # print("\nCHANGES")
        # for k, v in changes.items():
        #     if v != 0:
        #         print(k, v)
        # print("\n")
        # print("MAP " + str(i+1))
        for k, v in changes.items():
            if v != 0:
                if k not in map.keys():
                    map[k] = v
                else:
                    map[k] = map[k] + v

        # for k, v in map.items():
        #     if v != 0:
        #         print(k, v)
    print(sum(map.values()))



with open("input.txt") as f:
    data = f.readline().strip().split(" ")
    print(data)
    part1(data)
    # part2(data)