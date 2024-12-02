with open("input.txt") as file:
    data = file.readlines()
    for i in range(len(data)):
        data[i] = data[i].strip()
        input = data[i].split(' ')
        input.remove('')
        input.remove('')
        data[i] = input
    array1 = []
    array2 = []
    for d in data:
        array1.append(int(d[0]))
        array2.append(int(d[1]))
    array1.sort()
    array2.sort()
    diff = 0
    for i in range(len(array1)):
        diff += abs(array1[i] - array2[i])

    print(diff)