
wrong = []

def part1(rules, updates):
    s = 0
    for u in updates:
        ok =  True
        for i in range(1, len(u)):
            if u[i] in rules[u[i-1]]:
                continue
            else:
                ok = False
                break
        if ok:
            s += int(u[int(len(u)/2)])
        else:
            wrong.append(u)
    print(s)

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] in rules[arr[j+1]]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

def part2(rules, updates):
    s = 0
    for w in wrong:
        bubble_sort(w)
        s += int(w[int(len(w)/2)])
    print(s)

with open("input.txt") as f:
    data = f.readlines()
    r = data[:data.index("\n")]
    u = data[data.index("\n") + 1:]
    rules = {}
    updates = []
    for el in r:
        el = el.replace("\n", "")
        info = el.split("|")
        if info[0] in rules:
            rules[info[0]].append(info[1])
        else:
            rules[info[0]] = [info[1]]
    missed = []
    for value in rules.values():
        for v in value:
            if rules.get(v) is None:
                missed.append(v)
    for m in missed:
        rules[m] = []
    for el in u:
        el = el.replace("\n", "")
        updates.append(el.split(","))
    part1(rules, updates)
    part2(rules, updates)