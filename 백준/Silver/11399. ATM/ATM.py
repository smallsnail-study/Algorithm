import sys
input = sys.stdin.readline

N = int(input())
times = list(map(int, input().split()))

times_sort = sorted(times)
ans = 0

for i in range(len(times_sort)):
    ans += times_sort[i] * (N - i)

print(ans)