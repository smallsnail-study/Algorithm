import sys
from bisect import *

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

m = int(sys.stdin.readline())
queries = list(map(int, sys.stdin.readline().split()))

for query in queries:
    i = bisect_left(arr, query)
    if i != len(arr) and arr[i] == query:
        print(1)
    else:
        print(0)