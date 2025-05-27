import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

arr_unique = list(set(arr))
arr_unique.sort()

mapper = {}
for i, ele in enumerate(arr_unique):
    mapper[ele] = i

ans = [0] * N
for i, ele in enumerate(arr):
   ans[i] = mapper[ele]

print(*ans)