from itertools import combinations

numbers = [int(input()) for _ in range(9)]

for combi in combinations(numbers, 7):
    if sum(combi) == 100:
        for num in combi:
            print(num)
        break