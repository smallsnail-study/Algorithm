import sys
read_line = sys.stdin.readline

n = int(read_line())
nums = set(map(int, read_line().split()))

m = int(read_line())
query = list(map(int, read_line().split()))

for num in query:
    print(1 if num in nums else 0)