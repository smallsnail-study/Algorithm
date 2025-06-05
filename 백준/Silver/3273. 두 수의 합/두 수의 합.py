import sys
read_line = sys.stdin.readline

def count_pairs(arr, target):
    seen = {}
    count = 0
    
    for num in arr:
        complement = target - num
        if complement in seen:
            count += 1
        seen[num] = True
    
    return count

n = int(read_line())
arr = list(map(int, read_line().split()))
target = int(read_line())
print(count_pairs(arr, target))