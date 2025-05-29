import sys
read_line = sys.stdin.readline

n = int(read_line())
cards = set(map(int, read_line().split()))

m = int(read_line())
query = list(map(int, read_line().split()))

print(" ".join(["1" if num in cards else "0" for num in query]))