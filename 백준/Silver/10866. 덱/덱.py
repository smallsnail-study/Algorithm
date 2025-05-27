import sys
from collections import deque

N = int(sys.stdin.readline())
d = deque()

for _ in range(N):
    command = sys.stdin.readline().split()

    if command[0] == "push_front":
        d.appendleft(int(command[1]))

    elif command[0] == "push_back":
        d.append(int(command[1]))

    elif command[0] == "pop_front":
        if not d:
            print(-1)
        else:
            print(d.popleft())

    elif command[0] == "pop_back":
        if not d:
            print(-1)
        else:
            print(d.pop())

    elif command[0] == "size":
        print(len(d))

    elif command[0] == "empty":
        if not d:
            print(1)
        else: print(0)

    elif command[0] == "front":
        if not d:
            print(-1)
        else:
            print(d[0])

    else:
        if not d:
            print(-1)
        else:
            print(d[-1])