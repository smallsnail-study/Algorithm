import sys
from collections import deque

N = int(sys.stdin.readline())
dq = deque()

for i in range(N):
    dq.append(i+1)

while len(dq) > 1:
    dq.popleft()
    dq.append(dq.popleft())

print(dq[0])