import sys
read_line = sys.stdin.readline

N, M = map(int, read_line().split())
arr = list(map(int, read_line().split()))
sum_subarr = 0
left, right = 0, 0
count = 0

while right < N:
    sum_subarr += arr[right]
    right += 1
    
    while sum_subarr > M and left < right:
        sum_subarr -= arr[left]
        left += 1
    
    if sum_subarr == M:
        count += 1

print(count)